package com.mofany.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description RedisConfig Cache配置类
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {


}
