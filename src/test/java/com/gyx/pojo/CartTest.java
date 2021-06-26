package com.gyx.pojo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart = new Cart();

    @Test
    void addItem() {
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(20, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(30))));
        System.out.println(cart);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    void deleteItem() {
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(20, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(30))));
        cart.deleteItem(10);
        System.out.println(cart);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    void clear() {
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(20, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(30))));
        cart.clear();
        System.out.println(cart);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    void updateCount() {
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(10, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(20))));
        cart.addItem(new CartItem(20, "goods", 20, new BigDecimal(30), new BigDecimal(30).multiply(new BigDecimal(30))));
        cart.updateCount(20, 100);
        System.out.println(cart);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}