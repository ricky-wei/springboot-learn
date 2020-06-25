package com.wrq.aop.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author weiruiqi
 * @date 2020/1/16 19:08
 */
@Setter
@Getter
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 错误消息映射，用于映射活动交互语中的占位符
     */
    private Object[] args;

    public BaseException(String errorCode) {
        this.errorCode = errorCode;
        this.message = MessageUtil.getMessage(errorCode);
    }

    public BaseException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.message = MessageUtil.getMessage(errorCode, args);
    }

    @Override
    public String toString() {
        String name = this.getClass().getName();
        String message = this.getMessage();
        return message != null ? name + ":" + message : name;
    }
}
