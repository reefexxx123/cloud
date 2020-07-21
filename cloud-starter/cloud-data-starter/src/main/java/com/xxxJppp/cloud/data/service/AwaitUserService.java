package com.xxxJppp.cloud.data.service;

import com.xxxJppp.cloud.auth.utils.SecurityUtils;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.common.model.SecurityUser;
import com.xxxJppp.cloud.common.utils.StringUtils;
import com.xxxJppp.cloud.uc.api.domain.MemLoginDTO;
import com.xxxJppp.cloud.uc.api.feign.RemoteUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 同步调用用户服务
 *
 * @author ruoyi
 */
@Service
public class AwaitUserService {
    private static final Logger log = LoggerFactory.getLogger(AwaitUserService.class);

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 查询当前用户信息
     *
     * @return 用户基本信息
     */
    public SecurityUser info() {
        String username = SecurityUtils.getUsername();
        Result<SecurityUser> userResult = remoteUserService.getUserInfoByUsername(username);
        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData())) {
            log.info("数据权限范围查询用户：{} 不存在.", username);
            return null;
        }
        return userResult.getData();
    }

    /**
     * 查询当前用户信息
     *
     * @return 用户基本信息
     */
    public MemLoginDTO info(Long userId) {
        Result<MemLoginDTO> userResult = remoteUserService.getUserInfoByUserId(userId);
        return userResult.getData();
    }
}
