package com.minis.aop;

/**
 * @author yjc
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
