package com.minis.aop;

import java.lang.reflect.Method;

/**
 * @author yjc
 */
public interface MethodBeforeAdvice extends BeforeAdvice{


    void before(Method method, Object[] args, Object target) throws Throwable;

}
