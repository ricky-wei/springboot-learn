package com.wrq.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weiruiqi
 * @date 2020/1/16 17:44
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {

    /**
     * 当ignore=true时 该注解失效
     *
     * @return
     */
    boolean ignore() default false;
}
