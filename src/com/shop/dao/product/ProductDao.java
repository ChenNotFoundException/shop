package com.shop.dao.product;

import com.shop.dao.BaseDao;
import com.shop.model.product.Productinfo;

import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/25 15:30
 * @Content:
 */
public interface ProductDao extends BaseDao <Productinfo> {
    public List<Productinfo> findCommend();
    public List<Productinfo> findClickcount();
    public List<Productinfo> findSellCount();
}
