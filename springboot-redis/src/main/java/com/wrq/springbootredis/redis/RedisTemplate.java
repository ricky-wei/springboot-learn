package com.wrq.springbootredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author weiruiqi
 * @date 2019/12/1 18:24
 */
public abstract class RedisTemplate {

    final Charset charset = StandardCharsets.UTF_8;

    @Autowired
    RedisObjectSerializer serializer;


    public RedisConnection getConnection(StringRedisTemplate stringRedisTemplate) {
        return Objects.requireNonNull(stringRedisTemplate.getConnectionFactory()).getConnection();
    }

    /**
     * Set the value of a key
     *
     * @param key   key
     * @param value value
     */
    public abstract void set(String key, Object value) throws Exception;
}
