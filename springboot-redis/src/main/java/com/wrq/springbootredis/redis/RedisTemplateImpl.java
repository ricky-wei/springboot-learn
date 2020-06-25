package com.wrq.springbootredis.redis;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author weiruiqi
 * @date 2019/12/1 18:38
 */
@Log
@Component
public class RedisTemplateImpl extends RedisTemplate {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value) throws Exception {
        RedisConnection connection = getConnection(stringRedisTemplate);
        try {
            connection.set(key.getBytes(charset), Objects.requireNonNull(serializer.serialize(value)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
