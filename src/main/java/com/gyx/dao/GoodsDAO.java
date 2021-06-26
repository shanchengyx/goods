package com.gyx.dao;

import com.gyx.pojo.Goods;

import java.util.List;

public interface GoodsDAO {
    /**
     * 添加货物
     *
     * @param goods
     * @return 影响的行数
     */
    int add(Goods goods);

    /**
     * 根据id删除货物
     *
     * @param id
     * @return 影响的行数
     */
    int deleteGoodsById(int id);

    /**
     * 更新货物信息
     *
     * @param goods
     * @return 影响的行数
     */
    int updateGoods(Goods goods);

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
     * 查询数据行数
     *
     * @return
     */
    int count();

    /**
     * 查询当前页对应的数据
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Goods> queryForPageItems(int pageNo, int pageSize);

    /**
     * 查询价格区间内的记录数
     *
     * @param min
     * @param max
     * @return
     */
    int countByPrice(int min, int max);

    /**
     * 查询价格区间内的记录
     *
     * @param pageNo
     * @param pageSize
     * @param min      最小价格
     * @param max      最大价格
     * @return
     */
    List<Goods> queryForPageItemsByPrice(int pageNo, int pageSize, int min, int max);
}
