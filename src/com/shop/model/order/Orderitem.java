package com.shop.model.order;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author chenchen
 * @date 2018/10/25 15:24
 * @Content:
 */
@Entity
@Table(name = "tb_orderitem", schema = "db_shop", catalog = "")
public class Orderitem {
    private int id;
    private int productId;
    private String productName;
    private Float productMarketprice;// 市场价格
    private double productPrice;
    private Integer amount =1;
    private Order order;// 所属订单

    public Float getProductMarketprice() {
        return productMarketprice;
    }

    public void setProductMarketprice(Float productMarketprice) {
        this.productMarketprice = productMarketprice;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productPrice")
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderitem that = (Orderitem) o;
        return id == that.id &&
                productId == that.productId &&
                Double.compare(that.productPrice, productPrice) == 0 &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, productName, productPrice, amount);
    }
}
