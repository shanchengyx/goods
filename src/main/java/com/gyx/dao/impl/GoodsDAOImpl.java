package com.gyx.dao.impl;

import com.gyx.dao.GoodsDAO;
import com.gyx.pojo.Goods;

import java.util.List;

public class GoodsDAOImpl extends BaseDAO<Goods> implements GoodsDAO {
    @Override
    public int add(Goods goods) {
        String sql = "insert into t_goods(id,`name`,price,sales,stock,img_path) " +
                "values(?,?,?,?,?,?)";
        int count = update(sql, goods.getId(), goods.getName(), goods.getPrice(), goods.getSales(),
                goods.getStock(), goods.getImgPath());
        return count;
    }

    @Override
    public int deleteGoodsById(int id) {
        String sql = "delete from t_goods where id = ?";
        int count = update(sql, id);
        return count;
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql = "update t_goods set " +
                "`name` = ?,price = ?,sales = ?,stock = ?,img_path = ? " +
                "where id = ?";
        int count = update(sql, goods.getName(), goods.getPrice(), goods.getSales(), goods.getStock(), goods.getImgPath(), goods.getId());
        return count;
    }

    @Override
    public Goods queryGoodsById(int id) {
        String sql = "select id,`name` name,price,sales,stock,img_path imgPath " +
                "from t_goods where id = ?";
        Goods goods = queryForOne(sql, id);
        return goods;
    }

    @Override
    public List<Goods> queryGoods() {
        String sql = "select id,`name` name,price,sales,stock,img_path imgPath " +
                "from t_goods";
        List<Goods> list = QueryForList(sql);
        return list;
    }

    @Override
    public int count() {
        String sql = "select count(*) from t_goods";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Goods> queryForPageItems(int pageNo, int pageSize) {
        String sql = "select id,`name` name,price,sales,stock,img_path imgPath " +
                "from t_goods limit ?,?";
        List<Goods> goodsList = QueryForList(sql, (pageNo - 1) * pageSize, pageSize);
        return goodsList;
    }

    @Override
    public int countByPrice(int min, int max) {
        String sql = "select count(*) from t_goods where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Goods> queryForPageItemsByPrice(int pageNo, int pageSize, int min, int max) {
        String sql = "select id,`name` name,price,sales,stock,img_path imgPath " +
                "from t_goods " +
                "where price between ? and ? " +
                "order by price " +
                "limit ?,?";
        List<Goods> goodsList = QueryForList(sql, min, max, (pageNo - 1) * pageSize, pageSize);
        return goodsList;
    }
}
