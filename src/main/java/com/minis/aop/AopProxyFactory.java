package com.minis.aop;

/**
 * @author yjc
 */
public interface AopProxyFactory {

    AopProxy createAopProxy(Object target, PointcutAdvisor advisor);

}
