package com.wang.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*
* Servlet开发流程
* 1.创建javaWeb项目,同时将Tomcat添加为当前项目的依赖
* 2.重写service方法
* 3.在service方法当中写处理业务逻辑的代码
* 4.在web.xml文件当中,配置Servlet对应的请求映射路径*/


public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从request对象当中,获取所有请求中的信息(如username参数)
        String username = req.getParameter("username"); //该方法传入一个字符串(键),获取值

        String info = "YES";

        //如果用户名一样,代表重复,info变为NO
        if (username.equals("wyh")) {
            info = "NO";
        }

        //将要响应的数据放到response对象
        //设置响应头的ContentType属性
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();  //该方法返回的是一个向响应体中打印字符串的打印流
        writer.print(info);

        System.out.println(info);
    }
}
