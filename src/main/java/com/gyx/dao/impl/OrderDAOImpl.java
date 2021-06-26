package com.gyx.dao.impl;

import com.gyx.dao.OrderDAO;
import com.gyx.pojo.Order;

import java.util.List;

public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order values(?,?,?,?,?)";
        int count = update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        return count;
    }

    @Override
    public List<Order> queryMyOrders(int userId) {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId " +
                "from t_order " +
                "where user_id = ?";
        List<Order> orderList = QueryForList(sql, userId);
        return orderList;
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId " +
                "from t_order ";
        List<Order> orderList = QueryForList(sql);
        return orderList;
    }

    @Override
    public int changeOrderStatus(String orderId, int status) {
        String sql = "update t_order " +
                "set status = ? " +
                "where order_id = ?";
        int count = update(sql, status, orderId);
        return count;
    }
}
