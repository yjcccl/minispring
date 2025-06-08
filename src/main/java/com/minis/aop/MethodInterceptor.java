package com.minis.aop;

/**
 * @author yjc
 */
public interface MethodInterceptor extends Interceptor{


    Object invoke(MethodInvocation invocation) throws Throwable;
}
