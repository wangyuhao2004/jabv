package com.wang.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wang.schedule.common.Result;
import com.wang.schedule.common.ResultCodeEnum;
import com.wang.schedule.pojo.SysUser;
import com.wang.schedule.service.SysUserService;
import com.wang.schedule.service.impl.SysUserServiceImpl;
import com.wang.schedule.util.MD5Util;
import com.wang.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();


    /**
     * 注册时接受用户名,校验用户名是否被占用的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //获取注册时输入的用户名
        String username = req.getParameter("username");
        //调用服务层方法,判断用户名是否已经被占用
        SysUser byUsername = userService.findByUsername(username);
        //如果被占用,响应已占用,否则响应可用
        Result result = Result.ok(null);
        if (byUsername != null) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //将result对象,响应给客户端
        WebUtil.writeJson(resp,result);
    }

    /**
     * 接收注册业务请求的业务处理方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //接受注册时客户端提交的json串,使用WebUtil工具类中的方法,将接受的数据转化为对象
        SysUser registUser = WebUtil.readJson(req, SysUser.class);
        //调用服务层方法,完成注册功能
        int row = userService.regist(registUser);
        Result result = null;
        //根据注册结果,实现页面跳转
        if (row > 0) {
           result = Result.ok(null);
        } else {
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);

    }

    /**
     * 接收用户登录业务请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //接收用户请求参数
        //获取要登录的用户名密码
        SysUser inputUser = WebUtil.readJson(req, SysUser.class);
        //调用服务层方法,完成登录功能
        //判断输入的用户名和密码在数据库中是否存在
        //根据输入的用户名在数据库中查询,如果有将查询结果封装成一个SysUser对象返回
        SysUser loginUser = userService.findByUsername(inputUser.getUsername());

        Result result = null;
        if (loginUser == null) {
            //如果为null,代表用户名输入错误,或者不存在
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }else if (! MD5Util.encrypt(inputUser.getUserPwd()).equals(loginUser.getUserPwd())) {
            result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        } else {
            // 登录成功,将用户信息存入session
            req.getSession().setAttribute("sysUser",loginUser);
            // 登录成功
            // 将密码请空后,将用户信息响应给客户端
            loginUser.setUserPwd("");
            Map<String,Object> data =new HashMap<>();
            data.put("loginUser",loginUser);
            result=Result.ok(data);
        }
        WebUtil.writeJson(resp,result);
    }
}
