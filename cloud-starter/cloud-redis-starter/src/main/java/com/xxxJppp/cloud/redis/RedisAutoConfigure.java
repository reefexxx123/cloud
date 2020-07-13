package com.xxxJppp.cloud.redis;

import com.xxxJppp.cloud.redis.properties.CacheManagerProperties;
import com.xxxJppp.cloud.redis.repository.RedisRepository;
import com.xxxJppp.cloud.redis.repository.RedisService;
import com.xxxJppp.cloud.redis.serializer.RedisObjectSerializer;
import com.xxxJppp.cloud.common.constant.StarterNameConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * redis 配置类
 *
 * @author xxxJppp
 * @date 2020/4/30 10:13
 */
@Slf4j
@EnableCaching
@EnableConfigurationProperties({RedisProperties.class, CacheManagerProperties.class})
public class RedisAutoConfigure implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[CLOUD][" + StarterNameConstant.CLOUD_REDIS_STARTER + "]" + "redis模块已启动");
    }

    @Autowired
    private CacheManagerProperties cacheManagerProperties;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        RedisSerializer<Object> redisObjectSerializer = new RedisObjectSerializer();

        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(redisObjectSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public RedisRepository redisRepository(@Autowired RedisTemplate<String, Object> redisTemplate) {
        return new RedisRepository(redisTemplate);
    }

    @Bean
    public RedisService redisService(@Autowired RedisTemplate redisTemplate) {
        return new RedisService(redisTemplate);
    }

   /* @Bean
    public RedisDistributedLock redisDistributedLock(@Autowired RedisTemplate<String, Object> redisTemplate) {
        return new RedisDistributedLock(redisTemplate);
    }
*/
    @Primary
    @Bean(name = "cacheManager")
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration difConf = getDefConf().entryTtl(Duration.ofHours(1));

        //自定义的缓存过期时间配置
        int configSize = cacheManagerProperties.getConfigs() == null ? 0 : cacheManagerProperties.getConfigs().size();
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>(configSize);
        if (configSize > 0) {
            cacheManagerProperties.getConfigs().forEach(e -> {
                RedisCacheConfiguration conf = getDefConf().entryTtl(Duration.ofSeconds(e.getSecond()));
                redisCacheConfigurationMap.put(e.getKey(), conf);
            });
        }

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(difConf)
                .withInitialCacheConfigurations(redisCacheConfigurationMap)
                .build();
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(":").append(method.getName()).append(":");
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

    private RedisCacheConfiguration getDefConf() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .computePrefixWith(cacheName -> "cache".concat(":").concat(cacheName).concat(":"))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new RedisObjectSerializer()));
    }


}
