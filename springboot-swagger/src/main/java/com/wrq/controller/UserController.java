package com.wrq.controller;

import com.wrq.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author weiruiqi
 * @date 2021/3/30 23:56
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    private static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());


    @GetMapping("/")
    @ApiOperation(value = "获取用列表")
    public List<User> getUserList() {
        return new ArrayList<>(UserController.userMap.values());
    }

    @PostMapping("/")
    @ApiOperation(value = "创建用户信息", notes = "传入user对象")
    public String createUser(@RequestBody User user) {
        userMap.put(user.getId(), user);
        return "success";
    }
}
