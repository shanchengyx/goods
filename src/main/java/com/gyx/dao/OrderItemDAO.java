package com.gyx.dao;

import com.gyx.pojo.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    /**
     * 保存订单项
     *
     * @param orderItem 要保存的订单项
     * @return 影响的数据行数
     */
    int saveOrderItem(OrderItem orderItem);

    /**
     * 查询某个订单的订单项
     *
     * @param orderId 订单id
     * @return 查询到的订单项
     */
    List<OrderItem> queryOrderDetailByOrderId(String orderId);
}
