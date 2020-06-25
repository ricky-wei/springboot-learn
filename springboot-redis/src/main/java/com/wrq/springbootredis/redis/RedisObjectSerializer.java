package com.wrq.springbootredis.redis;

import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * redis存储对象的序列化与反序列化
 *
 * @author weiruiqi
 * @date 2019/12/1 18:25
 */
public interface RedisObjectSerializer extends RedisSerializer<Object> {

    /**
     * Deserialize
     *
     * @param source
     * @param tClass
     * @param <T>
     * @return
     * @throws SerializationFailedException
     */
    <T> T deserialize(byte[] source, Class<T> tClass) throws SerializationFailedException;

    /**
     * Serialize
     *
     * @param object
     * @return
     * @throws SerializationFailedException
     */
    @Override
    byte[] serialize(Object object) throws SerializationFailedException;
}
