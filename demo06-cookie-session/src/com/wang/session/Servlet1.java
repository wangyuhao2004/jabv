package com.wang.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求中的参数
        String username = req.getParameter("username");

        //获取session对象
        HttpSession session = req.getSession();

        //获取session的ID
        String id = session.getId();
        System.out.println(id);

        //判断session是不是新创建的
        boolean aNew = session.isNew();
        System.out.println(aNew);

        //向session中存入数据
         session.setAttribute("username",username);

         resp.setContentType("text/html;");
         resp.getWriter().write("成功");
    }
}
