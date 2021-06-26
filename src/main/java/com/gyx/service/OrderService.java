package com.gyx.service;

import com.gyx.pojo.Cart;
import com.gyx.pojo.Order;
import com.gyx.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     *
     * @param cart   购物车
     * @param userId 用户id
     */
    String createOrder(Cart cart, int userId);

    /**
     * 查询某一用户的订单
     *
     * @param userId 用户id
     * @return 查询到的订单
     */
    List<Order> myOrders(int userId);

    /**
     * 查询所有订单
     *
     * @return 查询到的订单
     */
    List<Order> allOrders();

    /**
     * 查询订单明细，即查询某一订单的所有订单项
     *
     * @param orderId 订单id
     * @return 查询到的订单项
     */
    List<OrderItem> orderDetails(String orderId);

    /**
     * 发货
     *
     * @param orderId 订单id
     */
    void sendOrder(String orderId);

    /**
     * 收获
     *
     * @param orderId 订单id
     */
    void receiveOrder(String orderId);
}
