package com.shop.model.product;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author chenchen
 * @date 2018/10/25 15:26
 * @Content:
 */
@Entity
@Table(name = "tb_uploadfile", schema = "db_shop", catalog = "")
public class Uploadfile {
    private Integer id;
    private String path;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uploadfile that = (Uploadfile) o;
        return id == that.id &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }
}
