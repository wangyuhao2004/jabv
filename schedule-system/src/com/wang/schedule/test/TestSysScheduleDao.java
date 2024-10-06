package com.wang.schedule.test;

import com.wang.schedule.dao.SysScheduleDao;
import com.wang.schedule.dao.impl.SysScheduleDaoImpl;
import com.wang.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestSysScheduleDao {

    private static SysScheduleDao scheduleDao;

    @BeforeClass
    public static void initScheduleDao() {
        scheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule() throws SQLException {
        int i = scheduleDao.addSchedule(new SysSchedule(null, 2, "学习数据库", 1));
        System.out.println(i);
    }

    @Test
    public void testFindAll() throws SQLException {
        List<SysSchedule> all = scheduleDao.findAll();
        all.forEach(System.out::println);
    }
}
