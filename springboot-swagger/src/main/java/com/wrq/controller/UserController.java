package com.wrq.controller;

import com.wrq.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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


    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping("/")
    @ApiOperation(value = "获取用列表")
    public List<User> getUserList() {
        return new ArrayList<>(UserController.userMap.values());
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/")
    @ApiOperation(value = "创建用户信息", notes = "传入user对象")
    public String createUser(@RequestBody User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查询用户信息", notes = "根据用户id查询用户信息")
    public User getUserById(@PathVariable Long id) {
        return userMap.get(id);
    }

    /**
     * 根据用户id更新用户信息
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    @ApiImplicitParam(paramType = "path", dataType = "Long",
            name = "id", value = "用户编号", required = true, example = "1")
    @ApiOperation(value = "更新用户信息", notes = "根据用户id和传入的用户更新信息")
    public String updateUserById(@PathVariable Long id, @RequestBody User user) {
        User user1 = userMap.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        userMap.put(id, user1);
        return "success";
    }

    /**
     * 根据用户id 删除用户信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户信息")
    public String deleteUserById(@PathVariable Long id) {
        userMap.remove(id);
        return "success";
    }
}
