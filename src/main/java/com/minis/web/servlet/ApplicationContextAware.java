package com.minis.web.servlet;

import com.minis.beans.factory.exception.BeansException;
import com.minis.context.ApplicationContext;

/**
 * @author yjc
 */
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
