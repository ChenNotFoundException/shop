package com.shop.model.product;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chenchen
 * @date 2018/10/25 15:26
 * @Content:
 */
@Entity
@Table(name = "tb_productcategory", schema = "db_shop", catalog = "")
public class Productcategory {
    private Integer id;
    private String name;
    private Integer level =1;
    private Set<Productcategory> children;// 子产品类别
    private Productcategory parent;// 父类别
    private Set<Productinfo> products = new TreeSet<Productinfo>();// 包含商品

    public Set <Productcategory> getChildren() {
        return children;
    }

    public void setChildren(Set <Productcategory> children) {
        this.children = children;
    }

    public Productcategory getParent() {
        return parent;
    }

    public void setParent(Productcategory parent) {
        this.parent = parent;
    }

    public Set <Productinfo> getProducts() {
        return products;
    }

    public void setProducts(Set <Productinfo> products) {
        this.products = products;
    }

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
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productcategory that = (Productcategory) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level);
    }
}
