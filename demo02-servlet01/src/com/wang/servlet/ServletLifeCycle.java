package com.wang.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/servletLifeCycle" , loadOnStartup = 6) //loadOnStartup默认为-1,此时在tomcat启动时,不会是实例化该servlet,可以更改数值
public class ServletLifeCycle extends HttpServlet {
    /*
    * Servlet的生命周期
    * */

    public ServletLifeCycle() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
