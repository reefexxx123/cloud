package com.xxxJppp.cloud.uc.api.feign.fallback;

import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.uc.api.entity.SysOperLog;
import com.xxxJppp.cloud.uc.api.feign.RemoteLogService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务降级处理
 *
 * @author xxxJppp
 */
@Component
public class RemoteLogFallbackImpl implements FallbackFactory<RemoteLogService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackImpl.class);

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public Result<Boolean> saveLog(SysOperLog sysOperLog) {
                return null;
            }

            @Override
            public Result<Boolean> saveLogininfor(String username, String status, String message) {
                return null;
            }
        };

    }
}
