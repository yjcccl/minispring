package com.minis.aop;

import com.minis.util.PatternMatchUtils;

import java.lang.reflect.Method;

/**
 * @author yjc
 */
public class NameMatchMethodPointcut implements MethodMatcher, Pointcut {

    private String mappedName = "";

    public void setMappedName(String mappedName) {
        this.mappedName = mappedName;
    }

    @Override
    // 判断这个连接点是否需要被拦截
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().equals(mappedName) || isMatch(method.getName());
    }

    protected boolean isMatch(String methodName) {
        return PatternMatchUtils.simpleMatch(mappedName, methodName);
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
