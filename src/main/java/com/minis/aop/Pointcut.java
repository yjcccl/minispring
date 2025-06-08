package com.minis.aop;

/**
 * @author yjc
 */
public interface Pointcut {

    MethodMatcher getMethodMatcher();

}
