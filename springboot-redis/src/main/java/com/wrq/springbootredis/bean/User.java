package com.wrq.springbootredis.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author weiruiqi
 * @date 2019/10/16 12:55
 */
@Setter
@Getter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 31374443661763376L;

    private String userName;

    private Integer age;
}
