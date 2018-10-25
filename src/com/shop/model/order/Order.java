package com.shop.model.order;

import com.shop.model.OrderState;
import com.shop.model.PaymentWay;
import com.shop.model.user.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author chenchen
 * @date 2018/10/25 15:24
 * @Content:
 */
@Entity
@Table(name = "tb_order", schema = "db_shop")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orderId;
    private String name;
    private String address;
    private String mobile;
    private Customer customer;// 所属用户
    private Set<Orderitem> orderItems = new HashSet <>();// 所买商品
    private Float totalPrice;
    private Date createTime = new Date();
    private PaymentWay paymentWay;
    private OrderState orderState;

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set <Orderitem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set <Orderitem> orderItems) {
        this.orderItems = orderItems;
    }

    @Id
    @Column(name = "orderId")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "totalPrice")
    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "paymentWay")
    public PaymentWay getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(PaymentWay paymentWay) {
        this.paymentWay = paymentWay;
    }

    @Basic
    @Column(name = "orderState")
    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order tbOrder = (Order) o;
        return Objects.equals(orderId, tbOrder.orderId) &&
                Objects.equals(name, tbOrder.name) &&
                Objects.equals(address, tbOrder.address) &&
                Objects.equals(mobile, tbOrder.mobile) &&
                Objects.equals(totalPrice, tbOrder.totalPrice) &&
                Objects.equals(createTime, tbOrder.createTime) &&
                Objects.equals(paymentWay, tbOrder.paymentWay) &&
                Objects.equals(orderState, tbOrder.orderState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, name, address, mobile, totalPrice, createTime, paymentWay, orderState);
    }
}
