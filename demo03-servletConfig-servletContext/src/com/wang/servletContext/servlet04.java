package com.wang.servletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/servlet04" , loadOnStartup = 6)
public class servlet04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        * HttpServletRequest中的方法*/

        //请求行相关  POST/GET  uri  http/1.1
        System.out.println(req.getMethod());  //获取请求方式
        System.out.println(req.getScheme());  //获取请求协议
        System.out.println(req.getProtocol()); //获取请求协议及版本号
        System.out.println(req.getRequestURI());  // 获取请求的uri   项目内的资源路径
        System.out.println(req.getRequestURL());  //获取请求的url    项目内资源的完整路径

        //请求头相关  key:value  key:value  ...

        //根据名字获取单个请求头
        String headName = req.getHeader("Accept");
        System.out.println("Accept:" + headName);

        //获取全部的请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println(name + ":" + req.getHeader(name));
        }


    }
}
