package com.wang.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //获取session的id
        String id = session.getId();
        System.out.println(id);
        //判断session是不是新创建的
        boolean aNew = session.isNew();
        System.out.println(aNew);

        //从session当中读取用户名
        String attribute = (String) session.getAttribute("username");
        System.out.println("用户名为:" + attribute);
    }
}
