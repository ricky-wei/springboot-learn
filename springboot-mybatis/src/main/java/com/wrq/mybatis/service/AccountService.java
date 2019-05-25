package com.wrq.mybatis.service;

import com.wrq.mybatis.domain.Account;

import java.util.List;

public interface AccountService {

    //根据用户名查询数据
    List<Account> findByName(String name);

    //转账
    void transfer(String out, String in, Double money);
}
