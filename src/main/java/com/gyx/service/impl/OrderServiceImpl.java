package com.gyx.service.impl;

import com.gyx.dao.GoodsDAO;
import com.gyx.dao.OrderDAO;
import com.gyx.dao.OrderItemDAO;
import com.gyx.dao.impl.GoodsDAOImpl;
import com.gyx.dao.impl.OrderDAOImpl;
import com.gyx.dao.impl.OrderItemDAOImpl;
import com.gyx.pojo.*;
import com.gyx.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDAO orderDao = new OrderDAOImpl();
    OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private GoodsDAO goodsDAO = new GoodsDAOImpl();

    @Override
    public String createOrder(Cart cart, int userId) {
        //1.先保存订单
        //以当前时间+userId为订单id，保证订单id唯一
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String orderId = sdf.format(new Date(System.currentTimeMillis())) + userId;
        orderDao.saveOrder(new Order(orderId, new java.sql.Date(System.currentTimeMillis()), cart.getTotalPrice(), 0, userId));

        //2.再保存订单项
        //遍历，逐个保存
        for (CartItem cartItem : cart.getItems().values()) {
            orderItemDAO.saveOrderItem(new OrderItem(cartItem.getId(), cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId));
            //更新销售量和库存量
            Goods goods = goodsDAO.queryGoodsById(cartItem.getId());
            goods.setSales(goods.getSales() + cartItem.getCount());
            goods.setStock(goods.getStock() - cartItem.getCount());
            goodsDAO.updateGoods(goods);
        }
        return orderId;
    }

    @Override
    public List<Order> myOrders(int userId) {
        List<Order> orderList = orderDao.queryMyOrders(userId);
        return orderList;
    }

    @Override
    public List<Order> allOrders() {
        List<Order> orderList = orderDao.queryAllOrders();
        return orderList;
    }

    @Override
    public List<OrderItem> orderDetails(String orderId) {
        List<OrderItem> orderItemList = orderItemDAO.queryOrderDetailByOrderId(orderId);
        return orderItemList;
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 1);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 2);
    }
}
