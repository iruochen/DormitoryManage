package com.cn.ruochen.dormitory.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {
    // 静态集合
    private static List<String> urls = new ArrayList<>();

    // 无需登录可访问
    static {
        urls.add("/index.jsp");
        urls.add("/login.jsp");
        urls.add("/register.jsp");
        urls.add("/css");
        urls.add("/js");
        urls.add("/img");
        urls.add("/plugin");
    }

    /**
     * 拦截请求，通过session判断用户是否登录，未登录返回登录界面，否则放行
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // ServletRequest是HttpServletRequest父接口,需要强转
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 得到当前页面所在目录下全名称
        String urlPattern = req.getServletPath();
        // 得到页面所在服务器的绝对路径
        String path = req.getRequestURI();
        for (String url : urls) {
            if (url.equals(urlPattern) || path.contains(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        if (req.getSession().getAttribute("admin") == null) {
            resp.sendRedirect(req.getContextPath() + "/dormitory_manage_jsp/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }
}
