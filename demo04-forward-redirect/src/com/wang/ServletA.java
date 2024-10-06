package com.wang;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {

    /*
    请求转发的特点(背诵):
        请求转发通过HttpServletRequest对象获取请求转发器实现的
        请求转发是服务器内部的行为,对客户端是屏蔽的
        客户端只发送了一次请求,客户端地址栏不变
        服务端只产生了一对请求和响应对象,这一对请求和响应对象会继续传递给下一个资源
        因为全程只有一个HttpServletRequest对象,所以请求参数可以传递,请求域中的数据也可以传递的
        请求转发可以转发给其他Servlet动态资源,也可以转发给一些静态资源以实现页面跳转
        请求转发可以转发给WEB-INF下受保护的资源  这也是客户端访问WEB-INF下资源的唯一方式
        请求转发不能转发到本项目以外的外部资源
* */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletA执行了");

        //请求转发给ServletB,执行ServletB
        //创建请求转发器
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        requestDispatcher.forward(req,resp);

    }
}
