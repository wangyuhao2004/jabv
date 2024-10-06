package com.wang.schedule.test;

import com.wang.schedule.dao.BaseDao;
import com.wang.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestBaseDao {

    private static BaseDao baseDao;
    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() throws SQLException {
        String sql = "select count(*) from sys_user";
        Long l = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(l);
    }

    @Test
    public void testBaseQuery() throws SQLException {
        String sql = "select uid, username, user_pwd userPwd from sys_user;";
        List<SysUser> sysUsers = baseDao.baseQuery(SysUser.class, sql);
        sysUsers.forEach(System.out::println);
    }

    @Test
    public void testUpdate() throws SQLException {
        String sql = "insert into sys_schedule values(null,?,?,?);";
        int i = baseDao.baseUpdate(sql, 1, "学习Java", 0);
        System.out.println(i);
    }
}
