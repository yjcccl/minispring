package com.minis.beans.factory.config;

import com.minis.beans.factory.BeanFactory;
import com.minis.beans.factory.exception.BeansException;

/**
 * @author yjc
 */
public interface BeanFactoryPostProcessor {


    void postProcessBeanFactory(BeanFactory beanFactory) throws BeansException;

}
