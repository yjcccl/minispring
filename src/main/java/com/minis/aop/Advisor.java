package com.minis.aop;

/**
 * @author yjc
 */
public interface Advisor {

    MethodInterceptor getMethodInterceptor();

    void setMethodInterceptor(MethodInterceptor methodInterceptor);

}
