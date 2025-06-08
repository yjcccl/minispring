package com.minis.beans.factory.config;

/**
 * @author yjc
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject) throws IllegalAccessException;

    Object getSingleton(String beanName) throws IllegalAccessException;

    boolean containsSingleton(String beanName) throws IllegalAccessException;

    String[] getSingletonNames() throws IllegalAccessException;

}
