package com.gyx.service;

import com.gyx.pojo.Goods;
import com.gyx.pojo.Page;

import java.util.List;

public interface GoodsService {
    /**
     * 添加货物
     *
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 根据id删除货物
     *
     * @param id
     */
    void deleteGoodsById(int id);

    /**
     * 更新货物信息
     *
     * @param goods
     */
    void updateGoods(Goods goods);

    /**
     * 根据id查询货物
     *
     * @param id
     * @return 查询到的货物
     */
    Goods queryGoodsById(int id);

    /**
     * 查询所有货物
     *
     * @return 查询到的所有货物
     */
    List<Goods> queryGoods();

    /**
     * 获取当前页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Goods> page(int pageNo, int pageSize);

    /**
     * 按价格区间获取页面
     *
     * @param pageNo
     * @param pageSize
     * @param min      最小价格
     * @param max      最大价格
     * @return
     */
    Page<Goods> pageByPrice(int pageNo, int pageSize, int min, int max);
}
