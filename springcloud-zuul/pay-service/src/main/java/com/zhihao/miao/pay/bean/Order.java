package com.zhihao.miao.pay.bean;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/12
 * @since 1.0
 */
public class Order {

    private int orderId;

    private String payMoney;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", payMoney='" + payMoney + '\'' +
                '}';
    }
}
