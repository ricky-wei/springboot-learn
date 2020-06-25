package com.wrq.aop.entity;

import com.wrq.aop.annotation.CheckPhone;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

/**
 * @author weiruiqi
 * @date 2020/1/16 16:48
 */
@Setter
@Getter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 3635423173032426354L;

    private String name;

    @DecimalMin(value = "18", message = "年龄必须大于18岁")
    private String age;

    /**
     * 用户手机号码
     */
    @CheckPhone
    private String phone;
}
