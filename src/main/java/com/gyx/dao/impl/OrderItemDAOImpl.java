package com.gyx.dao.impl;

import com.gyx.dao.OrderItemDAO;
import com.gyx.pojo.OrderItem;

import java.util.List;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) " +
                "values(?,?,?,?,?)";
        int count = update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
        return count;
    }

    @Override
    public List<OrderItem> queryOrderDetailByOrderId(String orderId) {
        String sql = "select id,name,count,price,total_price totalPrice,order_id orderId " +
                "from t_order_item " +
                "where order_id = ?";
        List<OrderItem> orderItemList = QueryForList(sql, orderId);
        return orderItemList;
    }
}
