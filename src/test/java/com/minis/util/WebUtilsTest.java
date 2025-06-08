package com.minis.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * WebUtils工具类测试
 */
public class WebUtilsTest {

    public static void main(String[] args) {
        // 测试用例1：使用空前缀
        testWithEmptyPrefix();

        // 测试用例2：使用特定前缀
        testWithPrefix();
    }

    private static void testWithEmptyPrefix() {
        System.out.println("===== 测试空前缀 =====");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("username", "zhang_san");
        request.addParameter("age", "25");
        request.addParameter("user.address.city", "北京");

        Map<String, Object> params = WebUtils.getParametersStartingWith(request, "");
        System.out.println("空前缀结果：" + params);
        // 预期输出: {username=zhang_san, age=25, user.address.city=北京}
    }

    private static void testWithPrefix() {
        System.out.println("===== 测试指定前缀 =====");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("user.name", "zhang_san");
        request.addParameter("user.age", "25");
        request.addParameter("user.address.city", "北京");
        request.addParameter("page", "1");

        Map<String, Object> params = WebUtils.getParametersStartingWith(request, "user.");
        System.out.println("前缀'user.'结果：" + params);
        // 预期输出: {name=zhang_san, age=25, address.city=北京}
    }

    /**
     * 简单的HttpServletRequest模拟实现
     */
    static class MockHttpServletRequest implements HttpServletRequest {
        private final Map<String, String> parameters = new HashMap<>();

        public void addParameter(String name, String value) {
            parameters.put(name, value);
        }

        @Override
        public String getParameter(String name) {
            return parameters.get(name);
        }

        @Override
        public Enumeration<String> getParameterNames() {
            Vector<String> names = new Vector<>(parameters.keySet());
            return names.elements();
        }

        // 其他接口方法的默认实现，返回null或默认值
        // 实际测试中只需要getParameter和getParameterNames两个方法
        @Override
        public Map<String, String[]> getParameterMap() {
            Map<String, String[]> result = new HashMap<>();
            parameters.forEach((key, value) -> result.put(key, new String[] { value }));
            return result;
        }

        @Override
        public String[] getParameterValues(String name) {
            String value = parameters.get(name);
            return value != null ? new String[] { value } : null;
        }

        // 以下是HttpServletRequest接口的其他方法，为简化测试，这里都返回null或默认值
        @Override
        public Object getAttribute(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String getCharacterEncoding() {
            return null;
        }

        @Override
        public void setCharacterEncoding(String env) {
        }

        @Override
        public int getContentLength() {
            return 0;
        }

        @Override
        public long getContentLengthLong() {
            return 0;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public javax.servlet.ServletInputStream getInputStream() {
            return null;
        }

        @Override
        public String getProtocol() {
            return null;
        }

        @Override
        public String getScheme() {
            return null;
        }

        @Override
        public String getServerName() {
            return null;
        }

        @Override
        public int getServerPort() {
            return 0;
        }

        @Override
        public java.io.BufferedReader getReader() {
            return null;
        }

        @Override
        public String getRemoteAddr() {
            return null;
        }

        @Override
        public String getRemoteHost() {
            return null;
        }

        @Override
        public void setAttribute(String name, Object o) {
        }

        @Override
        public void removeAttribute(String name) {
        }

        @Override
        public java.util.Locale getLocale() {
            return null;
        }

        @Override
        public Enumeration<java.util.Locale> getLocales() {
            return null;
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public javax.servlet.RequestDispatcher getRequestDispatcher(String path) {
            return null;
        }

        @Override
        public String getRealPath(String path) {
            return null;
        }

        @Override
        public int getRemotePort() {
            return 0;
        }

        @Override
        public String getLocalName() {
            return null;
        }

        @Override
        public String getLocalAddr() {
            return null;
        }

        @Override
        public int getLocalPort() {
            return 0;
        }

        @Override
        public javax.servlet.ServletContext getServletContext() {
            return null;
        }

        @Override
        public javax.servlet.AsyncContext startAsync() {
            return null;
        }

        @Override
        public javax.servlet.AsyncContext startAsync(javax.servlet.ServletRequest servletRequest,
                javax.servlet.ServletResponse servletResponse) {
            return null;
        }

        @Override
        public boolean isAsyncStarted() {
            return false;
        }

        @Override
        public boolean isAsyncSupported() {
            return false;
        }

        @Override
        public javax.servlet.AsyncContext getAsyncContext() {
            return null;
        }

        @Override
        public javax.servlet.DispatcherType getDispatcherType() {
            return null;
        }

        @Override
        public String getAuthType() {
            return null;
        }

        @Override
        public javax.servlet.http.Cookie[] getCookies() {
            return null;
        }

        @Override
        public long getDateHeader(String name) {
            return 0;
        }

        @Override
        public String getHeader(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            return null;
        }

        @Override
        public int getIntHeader(String name) {
            return 0;
        }

        @Override
        public String getMethod() {
            return null;
        }

        @Override
        public String getPathInfo() {
            return null;
        }

        @Override
        public String getPathTranslated() {
            return null;
        }

        @Override
        public String getContextPath() {
            return null;
        }

        @Override
        public String getQueryString() {
            return null;
        }

        @Override
        public String getRemoteUser() {
            return null;
        }

        @Override
        public boolean isUserInRole(String role) {
            return false;
        }

        @Override
        public java.security.Principal getUserPrincipal() {
            return null;
        }

        @Override
        public String getRequestedSessionId() {
            return null;
        }

        @Override
        public String getRequestURI() {
            return null;
        }

        @Override
        public StringBuffer getRequestURL() {
            return null;
        }

        @Override
        public String getServletPath() {
            return null;
        }

        @Override
        public javax.servlet.http.HttpSession getSession(boolean create) {
            return null;
        }

        @Override
        public javax.servlet.http.HttpSession getSession() {
            return null;
        }

        @Override
        public String changeSessionId() {
            return null;
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            return false;
        }

        @Override
        public boolean authenticate(javax.servlet.http.HttpServletResponse response) {
            return false;
        }

        @Override
        public void login(String username, String password) {
        }

        @Override
        public void logout() {
        }

        @Override
        public javax.servlet.http.Part getPart(String name) {
            return null;
        }

        @Override
        public java.util.Collection<javax.servlet.http.Part> getParts() {
            return null;
        }

        @Override
        public <T extends javax.servlet.http.HttpUpgradeHandler> T upgrade(Class<T> handlerClass) {
            return null;
        }
    }
}