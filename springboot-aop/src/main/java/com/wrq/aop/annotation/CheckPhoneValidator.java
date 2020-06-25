package com.wrq.aop.annotation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author weiruiqi
 * @date 2020/1/16 16:36
 */
public class CheckPhoneValidator implements ConstraintValidator<CheckPhone, String> {
    @Override
    public void initialize(CheckPhone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.isEmpty(phone)) {
            return Pattern.matches("^1\\d{10}$", phone);
        }
        return true;
    }
}
