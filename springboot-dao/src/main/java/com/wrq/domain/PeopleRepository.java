package com.wrq.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 使用spring-data-jpa操作数据库
 *
 * @author weiruiqi
 * @date 2019/10/9 10:57
 */
public interface PeopleRepository extends JpaRepository<People, Integer> {

    People findByName(String name);

    People findByNameAndAge(String name, Integer age);

    @Query("from people p where p.name=:name")
    People findPeople(@Param("name") String name);
}
