package com.gyx.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 */
public class Cart {
    private Integer totalCount = 0;//商品总数量
    private BigDecimal totalPrice = new BigDecimal(0);//商品总价格
    private Map<Integer, CartItem> items = new HashMap<>();//用一个map来存items

    public Cart() {
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品项
     *
     * @param item 要添加的商品项
     */
    public void addItem(CartItem item) {
        CartItem oldItem = items.get(item.getId());//在items中查询该item，查询到的item命名为oldItem
        //如果oldItem为空，说明之前没有加入过该商品，直接把item加入到items中即可
        if (oldItem == null) {
            items.put(item.getId(), item);
        } else {
            oldItem.setCount(oldItem.getCount() + item.getCount());
            oldItem.setTotalPrice(oldItem.getTotalPrice().add(item.getTotalPrice()));
        }
        //更新购物车总数量和总价格
        totalCount = totalCount + item.getCount();
        totalPrice = totalPrice.add(item.getTotalPrice());
    }

    /**
     * 根据id删除商品项
     *
     * @param id
     */
    public void deleteItem(int id) {
        CartItem item = items.get(id);
        //先判断购物车里有没有这个商品，没有就直接返回
        if (item == null) {
            return;
        }
        //更新购物车总数量和总价格
        totalCount = totalCount - item.getCount();
        totalPrice = totalPrice.subtract(item.getTotalPrice());
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
        totalCount = 0;
        totalPrice = new BigDecimal(0);
    }

    /**
     * 修改商品数目
     *
     * @param id    要修改的商品id
     * @param count 想修改成多少数量
     */
    public void updateCount(int id, int count) {
        CartItem item = items.get(id);//在items中查询该item
        //如果item为空，说明之前没有该商品,直接返回
        if (item == null) {
            return;
        }
        totalCount = totalCount - item.getCount() + count;
        totalPrice = totalPrice.subtract(item.getTotalPrice()).add(item.getPrice().multiply(new BigDecimal(count)));
        item.setCount(count);
        item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
    }
}
