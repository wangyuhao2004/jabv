package com.wang;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    /*  响应重定向要点(背诵):
            响应重定向通过HttpServletResponse对象的sendRedirect方法实现
            响应重定向是服务端通过302响应码和路径,告诉客户端自己去找其他资源,是在服务端提示下的,客户端的行为
            客户端至少发送了两次请求,客户端地址栏是要变化的
            服务端产生了多对请求和响应对象,且请求和响应对象不会传递给下一个资源
            因为全程产生了多个HttpServletRequest对象,所以请求参数不可以传递,请求域中的数据也不可以传递
            重定向可以是其他Servlet动态资源,也可以是一些静态资源以实现页面跳转
            重定向不可以到给WEB-INF下受保护的资源
            重定向可以到本项目以外的外部资源
    */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1执行了");

        //因为为响应重定向,所以在servlet1当中获取的请求行(username)不会传递到servlet2
        String username = req.getParameter("username");
        System.out.println("username: " + username);

        //响应重对象
        resp.sendRedirect("servlet2");
    }
}
