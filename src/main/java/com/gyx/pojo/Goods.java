package com.gyx.pojo;

import java.math.BigDecimal;

/**
 * 货物
 */
public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
    private int sales;//销量
    private int stock;//库存
    private String imgPath = "/static/img/default.jpg";//展示图片链接

    public Goods() {
    }

    public Goods(Integer id, String name, BigDecimal price, int sales, int stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if (imgPath != null && !("".equals(imgPath))) {
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
