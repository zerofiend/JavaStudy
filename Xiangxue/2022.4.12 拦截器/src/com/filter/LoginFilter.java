package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //基于http请求
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //filterChain.doFilter(req,resp);
        //当用户没有登录的时候拦截请求跳转到登录页面
        // resp.sendRedirect("login.jsp");//也是请求  会多次请求  又进到了过滤器 无限循环
        //指定放行页面  静态资源  登录  注册  都要放行
        //获取请求的路径
        String url = req.getRequestURI();
        if (url.contains("/login.jsp")) {
            filterChain.doFilter(req, resp);
            return;
        }
        if (url.contains("/js") || url.contains("/image") || url.contains("/css")) {
            filterChain.doFilter(req, resp);
            return;
        }

        if (url.contains("/login")) {
            filterChain.doFilter(req, resp);
            return;
        }
        String uname = (String) req.getSession().getAttribute("user");
        if (uname != null) {
            filterChain.doFilter(req, resp);
            return;
        }

        resp.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
