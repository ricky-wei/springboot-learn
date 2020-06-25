package com.wrq.springbootredis;

import com.wrq.springbootredis.bean.User;
import com.wrq.springbootredis.redis.RedisTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试redis是否连接成功
     */
    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("subject", "redis");
        Assert.assertEquals("redis", stringRedisTemplate.opsForValue().get("subject"));
    }

    @Test
    public void testSaveObject() throws Exception {

        User user = new User();
        user.setUserName("James");
        user.setAge(24);

        redisTemplate.set("James", user);
//        Assert.assertEquals(24, redisTemplate.opsForValue().get("Rose").getAge().longValue());
    }
}
