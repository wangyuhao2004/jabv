package com.wang.schedule.service;

import com.wang.schedule.pojo.SysUser;

import java.sql.SQLException;

/**
 * 该接口定义了以sys_user表格为核心的业务处理
 */
public interface SysUserService {
    /**
     * 用户完成注册业务的方法
     * @param sysUser registUser 用于保存注册用户名和密码的对象
     * @return 注册成功后返回的大于0的整数,否则返回0
     */
    int regist(SysUser sysUser) throws SQLException;

    /**
     * 用户登录的方法,通过输入的用户名在数据库当中查找
     * @param username 用户登陆时输入的用户名
     * @return 返回一个封装后的SysUser对象
     */
    SysUser findByUsername(String username) throws SQLException;
}
