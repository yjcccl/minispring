package com.minis.web.servlet;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yjc
 */
public interface HandlerMapping {

    HandlerMethod getHandler(HttpServletRequest request) throws Exception;


}
