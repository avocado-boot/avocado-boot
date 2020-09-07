package com.avocado.boot.starter.mybatis;

import java.util.List;

/**
 * @author ：qiaoliang
 */
public class PageInfo {
    /** 每页显示的行数*/
    private Integer pageSize = 5;

    /** 当前页码数（默认给1）*/
    private Integer pageNumber = 1;

    private List<String> orders;

    private PageInfo() {
    }

    public PageInfo(Integer pageSize, Integer pageNumber, List<String> orders) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.orders = orders;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

}
