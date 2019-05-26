package com.wrq.multidatasource.dao.primary;

import com.wrq.multidatasource.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountDao {

    //根据用户名查询数据
    List<Account> findAccountByName(@Param("username") String username);

}
