package com.wang.schedule.dao.impl;

import com.wang.schedule.dao.BaseDao;
import com.wang.schedule.dao.SysScheduleDao;
import com.wang.schedule.pojo.SysSchedule;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) throws SQLException {
        String sql = "insert into sys_schedule value(null,?,?,?);";
        int i = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return i;
    }

    @Override
    public List<SysSchedule> findAll() throws SQLException {
        String sql = "select sid, uid, title, completed from sys_schedule;";
        List<SysSchedule> scheduleList = baseQuery(SysSchedule.class, sql);
        return scheduleList;
    }

    @Override
    public List<SysSchedule> findItemListByUid(int uid) throws SQLException {
        String sql = "select sid, uid, title, completed from sys_schedule where uid = ?";
        List<SysSchedule> sysScheduleList = baseQuery(SysSchedule.class, sql,uid);
        return sysScheduleList;
    }

    @Override
    public int addDefaultSchedule(int uid) throws SQLException {
        String sql = "insert into sys_schedule value(null,?,'请输入日程',0)";
        return baseUpdate(sql,uid);
    }

    @Override
    public int updateSchedule(SysSchedule sysSchedule) throws SQLException {
        String sql ="update sys_schedule set title = ? ,completed =  ? where sid =?";
        return baseUpdate(sql,sysSchedule.getTitle(),sysSchedule.getCompleted(),sysSchedule.getSid());
    }

    @Override
    public int removeSchedule(int sid) throws SQLException {
        String sql ="delete from sys_schedule where sid = ?";
        return baseUpdate(sql,sid);
    }
}
