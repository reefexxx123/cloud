package com.xxxJppp.cloud.redis.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;

/**
 * CacheManagerProperties
 *
 * @author xxxJppp
 * @date 2020/4/30 10:16
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "cloud.redis.cache-manager")
public class CacheManagerProperties {

    private List<CacheConfig> configs;

    @Data
    public static class CacheConfig {
        /**
         * cache key
         */
        private String key;
        /**
         * 过期时间，sec
         */
        private long second = 60;
    }
}
