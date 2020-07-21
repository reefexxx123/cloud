package com.xxxJppp.cloud.data.config;

import com.xxxJppp.cloud.common.constant.StarterNameConstant;
import com.xxxJppp.cloud.data.properties.DatabaseProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 自动配置类
 *
 * @author xxxJppp
 * @version 1.0
 * @date 2020/7/20
 */
@Slf4j
@EnableConfigurationProperties({DatabaseProperties.class,})
public class PropertiesAutoConfiguration {

    public PropertiesAutoConfiguration() {
        log.info("[CLOUD][" + StarterNameConstant.CLOUD_DATA_STARTER + "]" + "自动加载配置启动");
    }

}
