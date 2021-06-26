package com.gyx.dao.impl;

import com.gyx.dao.GoodsDAO;
import com.gyx.pojo.Goods;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class GoodsDAOTest {
    private GoodsDAO dao = new GoodsDAOImpl();

    @Test
    void add() {
        int count = dao.add(new Goods(null, "扫把", new BigDecimal(10), 200, 200, null));
        System.out.println(count);
    }

    @Test
    void deleteGoodsById() {
        int count = dao.deleteGoodsById(8);
        System.out.println(count);
    }

    @Test
    void updateGoods() {
        int count = dao.updateGoods(new Goods(9, "金刚钻", new BigDecimal(100), 100, 100, ""));
        System.out.println(count);
    }

    @Test
    void queryGoodsById() {
        Goods goods = dao.queryGoodsById(4);
        System.out.println(goods);
    }

    @Test
    void queryGoods() {
        List<Goods> list = dao.queryGoods();
        list.forEach(System.out::println);
    }

    @Test
    void count() {
        int count = dao.count();
        System.out.println(count);
    }

    @Test
    void queryForPageItems() {
        List<Goods> goodsList = dao.queryForPageItems(1, 2);
        goodsList.forEach(System.out::println);
    }

    @Test
    void countByPrice() {
        int i = dao.countByPrice(50, 100);
        System.out.println(i);
    }

    @Test
    void queryForPageItemsByPrice() {
        List<Goods> goodsList = dao.queryForPageItemsByPrice(2, 4, 100, 200);
        goodsList.forEach(System.out::println);
    }
}