package com.minis.aop;

import java.lang.reflect.Method;

/**
 * @author yjc
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);

}
