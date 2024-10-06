package com.wang.schedule.service.impl;

import com.wang.schedule.dao.SysScheduleDao;
import com.wang.schedule.dao.impl.SysScheduleDaoImpl;
import com.wang.schedule.pojo.SysSchedule;
import com.wang.schedule.service.SysScheduleService;

import java.sql.SQLException;
import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {

    protected SysScheduleDao scheduleDao = new SysScheduleDaoImpl();

    @Override
    public List<SysSchedule> findItemListByUid(int uid) throws SQLException {
        //调用dao层方法,根据uid查询数据库日程
        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public boolean addDefaultSchedule(int uid) throws SQLException {
        //调用dao层方法,根据uid创建一行空数据
        return scheduleDao.addDefaultSchedule(uid) > 0;
    }

    @Override
    public boolean updateSchedule(SysSchedule sysSchedule) throws SQLException {
        //调用dao层的方法,修改数据库当中的数据
        return scheduleDao.updateSchedule(sysSchedule) > 0;
    }

    @Override
    public boolean removeSchedule(int sid) throws SQLException {
        //调用dao层的方法,删除数据表当中的数据
        return scheduleDao.removeSchedule(sid) > 0;
    }
}
