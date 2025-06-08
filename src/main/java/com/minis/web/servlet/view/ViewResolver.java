package com.minis.web.servlet.view;

/**
 * @author yjc
 */
public interface ViewResolver {


    View resolveViewName(String viewName) throws Exception;

}
