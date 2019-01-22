package com.qiekang.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail implements Serializable {


    private static final long serialVersionUID = 2789387867417944926L;

    private Integer id;
    private Integer orderId;
    private Integer productId;
    private String productSn;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer orderId, Integer productId, String productSn,
                       BigDecimal quantity, BigDecimal unitPrice, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.productSn = productSn;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
