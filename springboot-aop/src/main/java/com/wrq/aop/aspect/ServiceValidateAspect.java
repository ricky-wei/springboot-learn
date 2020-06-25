package com.wrq.aop.aspect;

import com.wrq.aop.annotation.ParamCheck;
import com.wrq.aop.exception.BaseException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/**
 * @author weiruiqi
 * @date 2020/1/16 17:34
 */
@Aspect
@Component
public class ServiceValidateAspect {

    /**
     * 定义service切点
     */
    @Pointcut("execution(* com.wrq.aop.service.impl.*.*(..))")
    public void servicePointCut() {
    }

    /**
     * service层入参校验
     */
    @Around("servicePointCut()")
    public Object serviceParamCheckAround(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ParamCheck paramCheck = method.getAnnotation(ParamCheck.class);
        if (paramCheck == null || paramCheck.ignore() == true) {
            return joinPoint.proceed();
        }
        //参数校验
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg == null) {
                continue;
            }
            String validateResult = null;
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(arg);
            Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<Object> error = iterator.next();
                validateResult = error.getMessage();
            }
            if (validateResult != null && validateResult.length() > 0) {
                //抛出参数校验的错误
                throw new BaseException("000000", validateResult);
            }
        }
        return joinPoint.proceed();
    }
}