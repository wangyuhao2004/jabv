package com.wang.schedule.service.impl;

import com.wang.schedule.dao.SysUserDao;
import com.wang.schedule.dao.impl.SysUserDaoImpl;
import com.wang.schedule.pojo.SysUser;
import com.wang.schedule.service.SysUserService;
import com.wang.schedule.util.MD5Util;

import java.sql.SQLException;
import java.util.PrimitiveIterator;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysUserDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) throws SQLException {
        //将用户的明文密码加密
        String encrypt = MD5Util.encrypt(sysUser.getUserPwd());
        sysUser.setUserPwd(encrypt);

        //调用Dao层的方法,将sysUser对象存入数据库
        return sysUserDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) throws SQLException {
        //调用Dao层的方法,在数据库当中查找
       return sysUserDao.findByUsername(username);
    }
}
