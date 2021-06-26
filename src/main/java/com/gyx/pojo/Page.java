package com.gyx.pojo;

import java.util.List;

/**
 * 分页
 *
 * @param <T> 泛型，表示对用户还是货物分页
 */
public class Page<T> {
    public static final int PAGE_SIZE = 4;//默认的每页记录数
    private Integer pageNo;//当前页码
    private Integer pageTotal;//总页码
    private Integer pageSize = PAGE_SIZE;//每页的记录数
    private Integer count;//总记录数
    private List<T> items;//当前页数据
    private String url;//分页地址

    public Page() {
    }

    public static int getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
