package com.wrq.mybatis;

import com.wrq.mybatis.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer() {

        try {
            accountService.transfer("aaa", "bbb", 200d);
            System.out.println("转账成功");
        } catch (Exception e) {
            System.out.println("转账失败");
            e.printStackTrace();
        }
    }

}
