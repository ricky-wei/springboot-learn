package com.wrq.service.impl;

import com.wrq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author weiruiqi
 * @date 2019/10/8 16:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(Integer id, String username, String password) {
        jdbcTemplate.update("insert into user(id,username,password) values (?,?,?)", id, username, password);
    }

    @Override
    public void deleteUserByName(String username) {
        jdbcTemplate.update("delete from user where username = ?", username);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user ");
    }
}
