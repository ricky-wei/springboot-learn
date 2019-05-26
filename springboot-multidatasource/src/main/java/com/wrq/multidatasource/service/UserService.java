package com.wrq.multidatasource.service;

import com.wrq.multidatasource.model.Account;
import com.wrq.multidatasource.model.User;

import java.util.List;

public interface UserService {


    List<Account> getAccount(String username);

    List<User> getUser(String username);

}
