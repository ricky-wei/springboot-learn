package com.wrq.springbootredis.redis;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

/**
 * @author weiruiqi
 * @date 2019/12/1 18:31
 */
@Lazy
@Component
public class RedisObjectSerializerImpl extends GenericJackson2JsonRedisSerializer implements RedisObjectSerializer {

    @Override
    public <T> T deserialize(byte[] source, Class<T> tClass) throws SerializationFailedException {
        return super.deserialize(source, tClass);
    }

    @Override
    public byte[] serialize(Object object) throws SerializationFailedException {
        return super.serialize(object);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return super.deserialize(bytes);
    }
}
