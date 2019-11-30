package com.wrq.springbootredis.bean;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.StringUtils;

/**
 * 实现对象的序列化
 *
 * @author weiruiqi
 * @date 2019/10/16 13:00
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object, byte[]> serializer = new SerializingConverter();

    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    public static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {

        if (o == null) {
            return EMPTY_ARRAY;
        } else {
            return serializer.convert(o);
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {

        if (StringUtils.isEmpty(bytes)) {
            return null;
        } else {
            return deserializer.convert(bytes);
        }
    }
}
