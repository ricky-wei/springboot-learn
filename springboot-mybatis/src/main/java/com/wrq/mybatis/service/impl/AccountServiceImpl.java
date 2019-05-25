package com.wrq.mybatis.service.impl;

import com.wrq.mybatis.dao.AccountDao;
import com.wrq.mybatis.domain.Account;
import com.wrq.mybatis.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public List<Account> findByName(String name) {
        return accountDao.findByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transfer(String out, String in, Double money) {

        accountDao.decreaseMoneyByName(out, money);

       // int i = 1 / 0;//除零异常

        accountDao.increaseMoneyByName(in, money);

    }


}
