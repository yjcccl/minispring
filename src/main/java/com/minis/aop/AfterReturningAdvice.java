package com.minis.aop;

import java.lang.reflect.Method;

/**
 * @author yjc
 */
public interface AfterReturningAdvice extends AfterAdvice{

    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;

}
