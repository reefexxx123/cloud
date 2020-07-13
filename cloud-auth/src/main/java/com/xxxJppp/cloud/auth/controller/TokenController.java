package com.xxxJppp.cloud.auth.controller;

import cn.hutool.core.util.StrUtil;
import com.xxxJppp.cloud.auth.utils.SecurityUtils;
import com.xxxJppp.cloud.common.base.BaseController;
import com.xxxJppp.cloud.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author
 * token
 */
@Api(tags = "令牌管理")
@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController extends BaseController {
	private final ClientDetailsService clientDetailsService;
	private final TokenStore tokenStore;
	private final RedisTemplate redisTemplate;

	/**
	 * 认证页面
	 * @param modelAndView
	 * @return ModelAndView
	 */
	@ApiOperation(value = "登录页面")
	@GetMapping("/login")
	public ModelAndView require(ModelAndView modelAndView) {
		modelAndView.setViewName("ftl/login");
		return modelAndView;
	}

	/**
	 * 确认授权页面
	 *
	 * @param request
	 * @param session
	 * @param modelAndView
	 * @return
	 */
	@ApiOperation(value = "确认授权页面")
	@GetMapping("/confirm_access")
	public ModelAndView confirm(HttpServletRequest request, HttpSession session, ModelAndView modelAndView) {
		Map<String, Object> scopeList = (Map<String, Object>) request.getAttribute("scopes");
		modelAndView.addObject("scopeList", scopeList.keySet());

		Object auth = session.getAttribute("authorizationRequest");
		if (auth != null) {
			AuthorizationRequest authorizationRequest = (AuthorizationRequest) auth;
			ClientDetails clientDetails = clientDetailsService.loadClientByClientId(authorizationRequest.getClientId());
			modelAndView.addObject("app", clientDetails.getAdditionalInformation());
			modelAndView.addObject("user", SecurityUtils.getUser());
		}

		modelAndView.setViewName("ftl/confirm");
		return modelAndView;
	}

	/**
	 * 退出token
	 *
	 * @param authHeader Authorization
	 */
	@ApiOperation(value = "退出登录")
	@DeleteMapping("/logout")
	public Result logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
		if (StrUtil.isBlank(authHeader)) {
			return Result.succeed(Boolean.FALSE, "退出失败，token 为空");
		}

		String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StrUtil.EMPTY).trim();
		OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
		if (accessToken == null || StrUtil.isBlank(accessToken.getValue())) {
			return Result.succeed(Boolean.TRUE, "退出失败，token 无效");
		}

		OAuth2Authentication auth2Authentication = tokenStore.readAuthentication(accessToken);

		// 清空access token
		tokenStore.removeAccessToken(accessToken);

		// 清空 refresh token
		OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
		tokenStore.removeRefreshToken(refreshToken);
		return Result.succeed(Boolean.TRUE);
	}

	/**
	 * 删除令牌
	 *
	 * @param token token
	 * @return
	 */
	@ApiOperation(value = "删除令牌")
	@DeleteMapping("/{token}")
	public Result<Boolean> delToken(@PathVariable("token") String token) {
		OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
		tokenStore.removeAccessToken(oAuth2AccessToken);
		return new Result<>();
	}
}
