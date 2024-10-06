package com.wang.schedule.service;

import com.wang.schedule.pojo.SysSchedule;

import java.sql.SQLException;
import java.util.List;

/**
 * 该接口定义了以sys_schedule表格为核心的业务处理
 */
public interface SysScheduleService {
    /**
     * 根据uid在数据库当中查询日程
     * @param uid
     * @return 返回的为一个list集合
     */
    List<SysSchedule> findItemListByUid(int uid) throws SQLException;

    /**
     * 根据uid在sys_schedule表当中创建一行空数据
     * @param uid
     * @return 创建成功返回true,失败返回false
     */
    boolean addDefaultSchedule(int uid) throws SQLException;

    /**
     * 根据传入的对象的,修改数据表中对应的数据
     * @param sysSchedule
     * @return
     * @throws SQLException
     */
    boolean updateSchedule(SysSchedule sysSchedule) throws SQLException;

    /**
     * 根据sid,删除数据表中对应的数据
     * @param sid
     * @return
     */
    boolean removeSchedule(int sid) throws SQLException;
}
