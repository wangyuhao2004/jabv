package com.wang.servletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/servlet05")
public class servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取键值对形式的参数
        //根据参数名称获取单个参数值
        String username = req.getParameter("username");
        System.out.println("username=" + username);
        String password = req.getParameter("password");
        System.out.println("password=" + password);
      /*  String hobby = req.getParameter("hobby");
        System.out.println(hobby);*/
        //根据参数名称获取多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("hobby=" + Arrays.toString(hobbies));

        System.out.println("================================");

        //获取所有的参数名
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] values = req.getParameterValues(name);
            if (values.length > 1) {
                System.out.println(name + "=" + Arrays.toString(values));
            } else {
                System.out.println(name + "=" + values[0]);
            }
        }

        System.out.println("================================");

        //获取所有的参数名和参数值,存入map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历map集合
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            //参数名
            String name = entry.getKey();
            //参数值,是一个数组,进行判断
            String[] value = entry.getValue();
            if (value.length > 1) {
                System.out.println(name + "=" + Arrays.toString(value));
            } else {
                System.out.println(name + "=" + value[0]);
            }
        }
    }
}
