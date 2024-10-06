package com.wang.schedule.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 过滤器,作用是:当用户未登录的时候不能访问showSchedule.html页面和映射路径为/schedule/*的servlet方法
 */
//@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取session对象
        HttpSession session = request.getSession();
        Object sysUser = session.getAttribute("SysUser");
        System.out.println(sysUser);
        //如果session域当中存在sysUser,代表已经登录,如果不存在,代表未登录
        if (sysUser != null) {
            //如果已经登录.放行
            filterChain.doFilter(servletRequest,servletResponse);

        } else {
            //如果未登录,跳转到登录页面
            response.sendRedirect("/login.html");
        }


    }
}
