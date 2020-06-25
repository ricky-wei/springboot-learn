package com.wrq.aop.exception;

import java.text.MessageFormat;

/**
 * @author weiruiqi
 * @date 2020/1/16 19:14
 */
public class MessageUtil {

    private final static String MESSAGE_TEMPLATE = "{0}";

    public static String getMessage(String code) {
        return "code=" + code + ",message=" + MESSAGE_TEMPLATE;
    }

    public static String getMessage(String code, Object... args) {
        return MessageFormat.format(getMessage(code), args);
    }
}
