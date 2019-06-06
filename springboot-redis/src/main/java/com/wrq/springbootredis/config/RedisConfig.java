package com.wrq.springbootredis.config;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;


/**
 * @Date 2019/6/6 16:39
 * @Author 10060950C
 * @ClassName RedisConfig
 * @Description redis配置类
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator keyGenerator() {

        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {

                StringBuilder sb=new StringBuilder();

                sb.append(o.getClass().getName());
                sb.append(method.getName());

                for(Object obj:objects){
                    sb.append(obj.toString());
                }

                return sb.toString();
            }
        };
    }

}
