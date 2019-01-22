package com.qiekang.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 8671311150911316203L;

    private Integer id;
    private Long sn;
    private Integer userId;
    private BigDecimal totalAmount;
    private Integer status;
    private Integer shopId;
    private Date createTime;
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    public Order() {

    }

    public Order(Integer id, Long sn, Integer userId, BigDecimal totalAmount, Integer status,
                 Integer shopId, Date createTime, Date updateTime, List<OrderDetail> orderDetailList) {
        this.id = id;
        this.sn = sn;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.shopId = shopId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.orderDetailList = orderDetailList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }
}
