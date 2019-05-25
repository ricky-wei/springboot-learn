package com.wrq.mybatis.dao;

import com.wrq.mybatis.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountDao {

    //根据用户名查询数据
    List<Account> findByName(@Param("name") String name);

    //进账
    void increaseMoneyByName(@Param("name") String name, @Param("money") Double money);

    //出账
    void decreaseMoneyByName(@Param("name") String name, @Param("money") Double money);
}
