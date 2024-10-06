package com.wang.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/s1")
public class servletContext extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       ServletContext servletContext = getServletContext();
        // 获得一个指向项目部署位置下的某个文件/目录的磁盘真实路径的API


        String path = servletContext.getRealPath("update\\a.txt");
        System.out.println(path);

        // 获得项目部署的上下文路径 项目的访问路径
        // 后续我们会学习在项目中使用相对和绝对路径找目标资源
        // 获取项目的上下文路径 项目的访问路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

    }
}
