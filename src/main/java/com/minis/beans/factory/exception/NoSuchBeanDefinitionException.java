package com.minis.beans.factory.exception;

/**
 * @author yjc
 */
public class NoSuchBeanDefinitionException extends Exception{

    public NoSuchBeanDefinitionException(String msg) {
        super(msg);
    }

}
