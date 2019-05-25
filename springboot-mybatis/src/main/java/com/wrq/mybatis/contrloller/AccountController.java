package com.wrq.mybatis.contrloller;


import com.wrq.mybatis.domain.Account;
import com.wrq.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public List<Account> getDataByName(@RequestParam(value = "name", required = true) String name) {
        return accountService.findByName(name);
    }
}
