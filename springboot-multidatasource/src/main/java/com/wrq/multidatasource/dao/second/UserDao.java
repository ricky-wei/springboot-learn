package com.wrq.multidatasource.dao.second;

import com.wrq.multidatasource.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> findUserByName(@Param("username") String username);
}
