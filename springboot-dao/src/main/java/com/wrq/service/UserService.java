package com.wrq.service;

/**
 * @author weiruiqi
 * @date 2019/10/8 16:12
 */
public interface UserService {

    /**
     * 创建用户
     * @param id
     * @param username
     * @param password
     */
    void createUser(Integer id,String username, String password);

    /**
     * 根据用户姓名删除用户
     * @param username
     */
    void deleteUserByName(String username);

    /**
     * 得到用户的总数量
     * @return
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
