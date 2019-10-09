package com.wrq;

import com.wrq.domain.People;
import com.wrq.domain.PeopleRepository;
import com.wrq.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weiruiqi
 * @date 2019/10/8 17:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoApplicationTest {


    @Autowired
    private UserService userService;

    @Autowired
    private PeopleRepository peopleRepository;

    @Before
    public void setup() {
        userService.deleteAllUsers();
    }

    @Test
    public void testJdbcTemplate() {
        userService.createUser(1, "Russ", "123456");
        userService.createUser(2, "Rose", "123456");

        Assert.assertEquals(2, userService.getAllUsers().intValue());
    }

    @Test
    public void testSpringDataJpa() {
        peopleRepository.save(new People("Rose", 32));
        peopleRepository.save(new People("Russ", 32));
        peopleRepository.save(new People("Ricky", 24));

    }

}
