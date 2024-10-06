package com.wang.schedule.dao;

import com.wang.schedule.pojo.SysUser;

import java.sql.SQLException;

public interface SysUserDao {
    /**
     *向数据库中增添一条用户信息的方法
     * @param sysUser  要增加的记录的username和user_pwd字段以SysUser实体类对象的形式接收
     * @return  成功返回1,失败返回0
     */
    int addSysUser(SysUser sysUser) throws SQLException;

    /**
     * 根据用户名在数据库当中查询数据
     * @param username 调用者要查询的用户的用户名
     * @return 如果存在,返回封装后的对象,否则返回null
     */
    SysUser findByUsername(String username) throws SQLException;
}
