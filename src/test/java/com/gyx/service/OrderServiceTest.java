package com.gyx.service;

import com.gyx.pojo.Cart;
import com.gyx.pojo.CartItem;
import com.gyx.pojo.Order;
import com.gyx.pojo.OrderItem;
import com.gyx.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderService service = new OrderServiceImpl();

    @Test
    void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(20, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(30))));
        service.createOrder(cart, 27);
    }

    @Test
    void myOrders() {
        List<Order> orderList = service.myOrders(27);
        orderList.forEach(System.out::println);
    }

    @Test
    void allOrders() {
        List<Order> orderList = service.allOrders();
        orderList.forEach(System.out::println);
    }

    @Test
    void orderDetails() {
        List<OrderItem> orderItems = service.orderDetails("2021052803230427");
        orderItems.forEach(System.out::println);
    }

    @Test
    void sendOrder() {
        service.sendOrder("2021052803230427");
    }

    @Test
    void receiveOrder() {
        service.receiveOrder("2021052803230427");
    }
}