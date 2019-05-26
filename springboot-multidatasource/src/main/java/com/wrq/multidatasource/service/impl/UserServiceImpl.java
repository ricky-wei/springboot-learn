package com.wrq.multidatasource.service.impl;

import com.wrq.multidatasource.dao.primary.AccountDao;
import com.wrq.multidatasource.dao.second.UserDao;
import com.wrq.multidatasource.model.Account;
import com.wrq.multidatasource.model.User;
import com.wrq.multidatasource.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private  UserDao userDao;

    @Resource
    private AccountDao accountDao;


    @Override
    public List<Account> getAccount(String username) {
        return accountDao.findAccountByName(username);
    }

    @Override
    public List<User> getUser(String username) {
        return userDao.findUserByName(username);
    }
}
