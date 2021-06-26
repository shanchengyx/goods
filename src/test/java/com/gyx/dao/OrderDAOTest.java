package com.gyx.dao;

import com.gyx.dao.impl.OrderDAOImpl;
import com.gyx.pojo.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    OrderDAO dao = new OrderDAOImpl();

    @Test
    void saveOrder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        int count = dao.saveOrder(new Order(sdf.format(date), new Date(date.getTime()), new BigDecimal(100), 0, 28));
        System.out.println(count);
    }

    @Test
    void queryMyOrders() {
        List<Order> orders = dao.queryMyOrders(28);
        orders.forEach(System.out::println);
    }

    @Test
    void queryAllOrders() {
        List<Order> orders = dao.queryAllOrders();
        orders.forEach(System.out::println);
    }

    @Test
    void changeOrderStatus() {
        int count = dao.changeOrderStatus("20210528124104", 2);
        System.out.println(count);
    }
}