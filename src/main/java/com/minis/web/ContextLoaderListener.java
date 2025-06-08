package com.minis.web;

import com.minis.beans.factory.exception.BeansException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author yjc
 */
public class ContextLoaderListener implements ServletContextListener {

    public static final String CONFIG_LOCATION_PARAM = "contextConfigLocation";

    private WebApplicationContext context;

    public ContextLoaderListener() {}

    public ContextLoaderListener(WebApplicationContext context) {
        this.context = context;
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            initWebApplicationContext(event.getServletContext());
        } catch (BeansException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void initWebApplicationContext(ServletContext servletContext) throws BeansException, IllegalAccessException {
        String sContextLocation = servletContext.getInitParameter(CONFIG_LOCATION_PARAM);
        WebApplicationContext wac = new XmlWebApplicationContext(sContextLocation);
        wac.setServletContext(servletContext);
        this.context = wac;
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);
    }



}
