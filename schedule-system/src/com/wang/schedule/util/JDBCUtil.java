package com.wang.schedule.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static DataSource dataSource;

    //初始化数据连接池
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //向外提供连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    //向外提供连接的方法
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
             connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    //定义一个归还连接的方法(解除和ThreadLocal之间的联系)
    public static void releaseConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null) {
            threadLocal.remove();
            connection.close();
        }
    }
}
