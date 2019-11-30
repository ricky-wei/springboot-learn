package com.wrq.springbootredis;

import com.wrq.springbootredis.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void contextLoads() {
    }

    /**
     * 测试redis是否连接成功
     */
    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("username", "Rose");
        Assert.assertEquals("Rose", stringRedisTemplate.opsForValue().get("username"));
    }

    @Test
    public void testSaveObject() {

        User user = new User();
        user.setUserName("Rose");
        user.setAge(24);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        Assert.assertEquals(24, redisTemplate.opsForValue().get("Rose").getAge().longValue());
    }
}
