package com.wang.schedule.controller;

import com.wang.schedule.common.Result;
import com.wang.schedule.common.ResultCodeEnum;
import com.wang.schedule.pojo.SysSchedule;
import com.wang.schedule.service.SysScheduleService;
import com.wang.schedule.service.impl.SysScheduleServiceImpl;
import com.wang.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    增加日程的请求  schedule/add
    查询日程的请求  schedule/find
    删除日程的请求  schedule/remove
    修改日程的请求  schedule/update
    ...
    ...
* */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {

    protected SysScheduleService sysScheduleService = new SysScheduleServiceImpl();

    /**
     * 根据客户端传来的uid,在表中查询日程的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //接受请求中的uid,查询用户的所有日程
        int uid = Integer.parseInt(req.getParameter("uid"));
        //根据uid在数据库当中查询日程
        //调用服务层方法查询,返回的是一个list集合,里面装的为SysSchedule对象
        List<SysSchedule> sysScheduleList = sysScheduleService.findItemListByUid(uid);

        //将用户的所有日程放入一个Result对象
        //将list集合用map集合存起来
        Map data = new HashMap<>();
        data.put("itemList",sysScheduleList);
        Result result = Result.ok(data);

        //将result对象,转化为JSON串响应给客户端
        WebUtil.writeJson(resp,result);

    }


    /**
     * 根据客户端传来的uid,在数据表当中创建一行空数据的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //根据uid,在数据库当中创建一行空数据
        int uid = Integer.parseInt(req.getParameter("uid"));
        //调用服务层方法,根据uid在数据表当中创建空数据
        boolean flag = sysScheduleService.addDefaultSchedule(uid);
        //将flag放入result对象
        Result result = Result.ok(flag);
        //将result对象变为json字符串响应出去
        WebUtil.writeJson(resp,result);
    }

    /**
     * 根据客户端传来的json串,修改数据表中对应的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //获取json串,将json串,变为SysSchedule对象
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        //调用服务层方法,根据sysSchedule对象,修改数据表中对应的数据
        boolean flag = sysScheduleService.updateSchedule(sysSchedule);
        //将flag放入result对象
        Result result = Result.ok(flag);
        WebUtil.writeJson(resp,result);
    }

    /**
     * 根据客户端传来的sid,删除数据表当中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        //调用服务层方法,根据sid删除数据
        boolean flag = sysScheduleService.removeSchedule(sid);
        //将flag放入result对象
        Result result = null;
        if (flag) {
            result = Result.ok(flag);
        } else {
            result = Result.build(flag, ResultCodeEnum.DELETION_FAILED);
        }
        WebUtil.writeJson(resp,result);
    }
}
