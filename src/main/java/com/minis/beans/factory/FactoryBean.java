package com.minis.beans.factory;

/**
 * @author yjc
 */
public interface FactoryBean<T> {


    T getObject() throws Exception;

    Class<?> getObjectType();

    default boolean isSingleton() {return true;}

}
