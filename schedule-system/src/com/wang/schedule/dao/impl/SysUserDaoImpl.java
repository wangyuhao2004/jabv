package com.wang.schedule.dao.impl;

import com.wang.schedule.dao.BaseDao;
import com.wang.schedule.dao.SysUserDao;
import com.wang.schedule.pojo.SysUser;
import com.wang.schedule.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) throws SQLException {
        String sql = "insert into sys_user values(null,?,?)";
        int row = baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
        return row;
    }

    @Override
    public SysUser findByUsername(String username) throws SQLException {
        String sql = "select uid, username, user_pwd as userPwd from sys_user where username = ?";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        if (sysUserList == null || sysUserList.size() == 0) {
            return null;
        }
        return sysUserList.getFirst();
    }
}
