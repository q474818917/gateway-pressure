package com.qiekang.core;

public enum OrderStatus {

    PAYING(0, "支付中"),
    SUCCESS(1, "支付成功"),
    FAIL(2, "支付失败"),
    CANCEL(3, "已取消");

    private int code;
    private String name;

    OrderStatus(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
