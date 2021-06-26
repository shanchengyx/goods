package com.gyx.dao.impl;

import com.gyx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDAO
 */
public abstract class BaseDAO<T> {
    private Class<T> tClass = null;
    QueryRunner runner = new QueryRunner();

    /**
     * 获取子类的父类泛型
     */ {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] typeArguments = paramType.getActualTypeArguments();
        tClass = (Class<T>) typeArguments[0];
    }


    /**
     * 更新
     *
     * @param sql
     * @param args
     * @return 更新操作影响的数据行数
     */
    public int update(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            int count = runner.update(conn, sql, args);
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询，获取一个实例
     *
     * @param sql
     * @param args
     * @return 返回一个查询到的实例
     */
    public T queryForOne(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            BeanHandler<T> handler = new BeanHandler<>(tClass);
            T t = runner.query(conn, sql, handler, args);
            return t;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询，获取符合条件的所有实例
     *
     * @param sql
     * @param args
     * @return 返回一个List，存放所有实例
     */
    public List<T> QueryForList(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            BeanListHandler<T> handler = new BeanListHandler<>(tClass);
            List<T> list = runner.query(conn, sql, handler, args);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询单个值
     *
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            ScalarHandler<Object> handler = new ScalarHandler<>();
            Object obj = runner.query(conn, sql, handler, args);
            return obj;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
