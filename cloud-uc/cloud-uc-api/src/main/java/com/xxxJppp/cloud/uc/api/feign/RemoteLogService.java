package com.xxxJppp.cloud.uc.api.feign;

import com.xxxJppp.cloud.common.constant.ServiceNameConstant;
import com.xxxJppp.cloud.common.model.Result;
import com.xxxJppp.cloud.uc.api.entity.SysOperLog;
import com.xxxJppp.cloud.uc.api.feign.fallback.RemoteLogFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 日志服务
 *
 * @author xxxJppp
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstant.CLOUD_UC_CENTER, fallbackFactory = RemoteLogFallbackImpl.class)
public interface RemoteLogService {
    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     * @return 结果
     */
    @PostMapping("/operlog")
    Result<Boolean> saveLog(@RequestBody SysOperLog sysOperLog);

    /**
     * 保存访问记录
     *
     * @param username 用户名称
     * @param status   状态
     * @param message  消息
     * @return 结果
     */
    @PostMapping("/logininfor")
    Result<Boolean> saveLogininfor(@RequestParam("username") String username, @RequestParam("status") String status,
                                   @RequestParam("message") String message);
}
