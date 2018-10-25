package com.shop.model.product;

import com.shop.model.Sex;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author chenchen
 * @date 2018/10/25 15:26
 * @Content:
 */
@Entity
@Table(name = "tb_productinfo", schema = "db_shop", catalog = "")
public class Productinfo {
    private Integer id;
    private String name;
    private String description;
    private Date createTime = new Date();
    private Float baseprice;
    private Float marketprice;
    private Float sellprice;
    private Sex sexrequest;
    private Boolean commend;
    private Integer clickcount = 1;
    private Integer sellCount = 0;
    private Productcategory category;// 所属类别
    private Uploadfile uploadFile;// 上传文件



    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "baseprice")
    public Float getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(Float baseprice) {
        this.baseprice = baseprice;
    }

    @Basic
    @Column(name = "marketprice")
    public Float getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Float marketprice) {
        this.marketprice = marketprice;
    }

    @Basic
    @Column(name = "sellprice")
    public Float getSellprice() {
        return sellprice;
    }

    public void setSellprice(Float sellprice) {
        this.sellprice = sellprice;
    }

    @Basic
    @Column(name = "sexrequest")
    public Sex getSexrequest() {
        return sexrequest;
    }

    public void setSexrequest(Sex sexrequest) {
        this.sexrequest = sexrequest;
    }

    @Basic
    @Column(name = "commend")
    public Boolean getCommend() {
        return commend;
    }

    public void setCommend(Boolean commend) {
        this.commend = commend;
    }

    @Basic
    @Column(name = "clickcount")
    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }

    @Basic
    @Column(name = "sellCount")
    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public Productcategory getCategory() {
        return category;
    }

    public void setCategory(Productcategory category) {
        this.category = category;
    }

    public Uploadfile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(Uploadfile uploadFile) {
        this.uploadFile = uploadFile;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productinfo that = (Productinfo) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(baseprice, that.baseprice) &&
                Objects.equals(marketprice, that.marketprice) &&
                Objects.equals(sellprice, that.sellprice) &&
                Objects.equals(sexrequest, that.sexrequest) &&
                Objects.equals(commend, that.commend) &&
                Objects.equals(clickcount, that.clickcount) &&
                Objects.equals(sellCount, that.sellCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createTime, baseprice, marketprice, sellprice, sexrequest, commend, clickcount, sellCount);
    }
}
