package com.gyx.service.impl;

import com.gyx.dao.GoodsDAO;
import com.gyx.dao.impl.GoodsDAOImpl;
import com.gyx.pojo.Goods;
import com.gyx.pojo.Page;
import com.gyx.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO dao = new GoodsDAOImpl();

    @Override
    public void addGoods(Goods goods) {
        dao.add(goods);
    }

    @Override
    public void deleteGoodsById(int id) {
        dao.deleteGoodsById(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        dao.updateGoods(goods);
    }

    @Override
    public Goods queryGoodsById(int id) {
        Goods goods = dao.queryGoodsById(id);
        return goods;
    }

    @Override
    public List<Goods> queryGoods() {
        List<Goods> list = dao.queryGoods();
        return list;
    }

    @Override
    public Page<Goods> page(int pageNo, int pageSize) {
        Page<Goods> page = new Page<>();
        int count = dao.count();//获取总记录数
        int pageTotal = 0;
        //要根据count能不能除得尽pageSize来设置pageTotal的值
        if (count % pageSize == 0) {
            pageTotal = count / pageSize;
        } else {
            pageTotal = count / pageSize + 1;
        }
        //判断pageNo有没有越界
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        //判断完pageNo后才能获取items
        List<Goods> items = dao.queryForPageItems(pageNo, pageSize);
        //给page设置参数
        page.setPageNo(pageNo);
        page.setPageTotal(pageTotal);
        page.setPageSize(pageSize);
        page.setCount(count);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Goods> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Goods> page = new Page<>();
        int count = dao.countByPrice(min, max);//获取价格区间内的记录数
        int pageTotal = 0;
        //要根据count能不能除得尽pageSize来设置pageTotal的值
        if (count % pageSize == 0) {
            pageTotal = count / pageSize;
        } else {
            pageTotal = count / pageSize + 1;
        }
        //判断pageNo有没有越界
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        //判断完pageNo后才能获取items
        List<Goods> items = dao.queryForPageItemsByPrice(pageNo, pageSize, min, max);
        //给page设置参数
        page.setPageNo(pageNo);
        page.setPageTotal(pageTotal);
        page.setPageSize(pageSize);
        page.setCount(count);
        page.setItems(items);
        return page;
    }
}
