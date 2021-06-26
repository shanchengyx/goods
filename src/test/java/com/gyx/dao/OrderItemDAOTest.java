package com.gyx.dao;

import com.gyx.dao.impl.OrderItemDAOImpl;
import com.gyx.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDAOTest {
    OrderItemDAO dao = new OrderItemDAOImpl();

    @Test
    void saveOrderItem() {
        int count = dao.saveOrderItem(new OrderItem(null, "亿万年的星光", 1, new BigDecimal(1000), new BigDecimal(1000), "20210528124104"));
        System.out.println(count);
    }

    @Test
    void queryOrderDetailByOrderId() {
        List<OrderItem> orderItemList = dao.queryOrderDetailByOrderId("20210528124104");
        orderItemList.forEach(System.out::println);
    }
}