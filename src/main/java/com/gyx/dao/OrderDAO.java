package com.gyx.dao;

import com.gyx.pojo.Order;

import java.util.List;

public interface OrderDAO {
    /**
     * 保存订单
     *
     * @param order 要保存的订单
     * @return 影响的数据行数
     */
    int saveOrder(Order order);

    /**
     * 查询某一用户订单
     *
     * @param userId 用户id
     * @return 查询到的订单
     */
    List<Order> queryMyOrders(int userId);

    /**
     * 查询所有订单
     *
     * @return 查询到的订单
     */
    List<Order> queryAllOrders();

    /**
     * 修改订单状态
     *
     * @param orderId 要修改的订单id
     * @param status  要修改成什么状态
     * @return 影响的数据行数
     */
    int changeOrderStatus(String orderId, int status);
}
