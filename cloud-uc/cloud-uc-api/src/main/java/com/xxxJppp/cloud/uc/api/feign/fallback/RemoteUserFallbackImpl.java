package com.xxxJppp.cloud.uc.api.feign.fallback;

import com.xxxJppp.cloud.uc.api.domain.MemLoginDTO;
import com.xxxJppp.cloud.uc.api.feign.RemoteUserService;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * RemoteLogFallbackImpl
 *
 * @author xxxJppp
 * @date 2020/4/29 21:43
 */
@Slf4j
@AllArgsConstructor
@Component
public class RemoteUserFallbackImpl implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        return new RemoteUserService() {
            @Override
            public Result<SecurityUser> getUserInfoByUsername(String username) {
                log.error("调用getUserInfoByUsername异常：{}", username, throwable);
                return Result.failed(null);
            }

            @Override
            public Result<SecurityUser> getUserInfoByMobile(String mobile) {
                log.error("调用getUserInfoByMobile异常：{}", mobile, throwable);
                return Result.failed(null);
            }

            @Override
            public Result<MemLoginDTO> getUserInfoByUserId(Long userId) {
                log.error("调用getUserInfoByUserId异常：{}", userId, throwable);
                return Result.failed(null);
            }
        };
    }
}
