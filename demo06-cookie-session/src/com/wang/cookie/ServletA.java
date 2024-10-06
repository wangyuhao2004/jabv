package com.wang.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie1 = new Cookie("key1","value1");
        //设置cookie1的存在时间(浏览器关闭也会存在)
        cookie1.setMaxAge(60);
        Cookie cookie2 = new Cookie("key2","value2");

        //向浏览器响应cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
