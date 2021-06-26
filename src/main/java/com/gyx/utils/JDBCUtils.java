package com.gyx.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 自定义的数据库工具类
 */
public class JDBCUtils {
    private static DataSource source = null;//数据库连接池
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();//用ThreadLocal来实现数据库事务

    /**
     * 静态代码块，用来初始化数据库连接池
     */
    static {
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = conns.get();//从ThreadLocal中取出连接
        //如果连接为空，说明还未向ThreadLocal中放入连接，此时直接从数据库连接池中取出连接
        if (conn == null) {
            try {
                conn = source.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭数据库连接
     */
    public static void commitAndClose() {
        Connection conn = conns.get();
        //如果连接为空，直接返回
        if (conn == null) {
            return;
        }
        try {
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        conns.remove();
    }

    /**
     * 回滚，并关闭数据库连接
     */
    public static void rollbackAndClose() {
        Connection conn = conns.get();
        //如果连接为空，直接返回
        if (conn == null) {
            return;
        }
        try {
            conn.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        conns.remove();
    }
}
