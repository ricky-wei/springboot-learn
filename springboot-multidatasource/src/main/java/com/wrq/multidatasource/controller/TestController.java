package com.wrq.multidatasource.controller;


import com.wrq.multidatasource.model.Account;
import com.wrq.multidatasource.model.User;
import com.wrq.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/account")
    public List<Account> testAccount(@RequestParam("username") String username) {

        return userService.getAccount(username);
    }

    @GetMapping("/user")
    public List<User> testUser(@RequestParam("username") String username) {
        return userService.getUser(username);
    }

}
