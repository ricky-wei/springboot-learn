package com.wrq.aop.service.impl;

import com.wrq.aop.annotation.ParamCheck;
import com.wrq.aop.service.UserService;
import com.wrq.aop.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author weiruiqi
 * @date 2020/1/16 17:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    @ParamCheck
    public void sayHello(User user) {
        System.out.println(user.toString());
    }
}
