package com.gyx.service;

import com.gyx.pojo.Goods;
import com.gyx.pojo.Page;
import com.gyx.service.impl.GoodsServiceImpl;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsServiceTest {
    GoodsService service = new GoodsServiceImpl();

    @Test
    void addGoods() {
        service.addGoods(new Goods(null, "风鹰剑", new BigDecimal(100), 10, 5, null));
    }

    @Test
    void deleteGoodsById() {
        service.deleteGoodsById(10);
    }

    @Test
    void updateGoods() {
        service.updateGoods(new Goods(2, "彩虹", new BigDecimal(100), 10, 10, null));
    }

    @Test
    void queryGoodsById() {
        Goods goods = service.queryGoodsById(11);
        System.out.println(goods);
    }

    @Test
    void queryGoods() {
        List<Goods> list = service.queryGoods();
        list.forEach(System.out::println);
    }

    @Test
    void page() {
        Page<Goods> page = service.page(2, 4);
        System.out.println(page);
    }

    @Test
    void pageByPrice() {
        Page<Goods> page = service.pageByPrice(2, 4, 100, 300);
        page.getItems().forEach(System.out::println);
    }
}