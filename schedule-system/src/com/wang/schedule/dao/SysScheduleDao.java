package com.wang.schedule.dao;

import com.wang.schedule.pojo.SysSchedule;

import java.sql.SQLException;
import java.util.List;

public interface SysScheduleDao {
    /**
     * 用于向数据中添加一条日程记录
     * @param schedule 日程数据以SysSchedule实体类形式入参
     * @return 返回影响数据库记录的行数,行数为0说明添加失败,为1说明添加成功
     */
    int addSchedule(SysSchedule schedule) throws SQLException;

    /**
     * 用于查询数据库sys_schedule表中中所有数据
     * @return 一个list集合,里面存了封装后的数据
     */
    List<SysSchedule> findAll() throws SQLException;

    /**
     * 根据uid在数据库当中查询所有日程的方法
     * @param uid
     * @return 一个list集合,里面为封装后的数据
     */
    List<SysSchedule> findItemListByUid(int uid) throws SQLException;

    /**
     * 根据uid在数据表sys_schedule表当中创建一行空数据
     * @param uid
     * @return 受影响的行数
     * @throws SQLException
     */
    int addDefaultSchedule(int uid) throws SQLException;

    /**
     * 根据传入的对象,在数据表当中修改数据
     * @param sysSchedule
     * @return
     */
    int updateSchedule(SysSchedule sysSchedule) throws SQLException;

    /**
     * 根基sid,删除数据表当中的数据
     * @param sid
     * @return
     */
    int removeSchedule(int sid) throws SQLException;
}
