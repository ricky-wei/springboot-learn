package com.wrq.aop;

import com.wrq.aop.service.impl.UserServiceImpl;
import com.wrq.aop.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootAopApplicationTests {


    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    /**
     * 手机号码校验测试
     */
    @Test
    public void Test1() {
        User user = new User();
        user.setName("Ricky");
        user.setAge("124");
        user.setPhone("15256211934");
        applicationContext.getBean(UserServiceImpl.class).sayHello(user);
    }

}
