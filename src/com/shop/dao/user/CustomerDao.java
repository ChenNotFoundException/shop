package com.shop.dao.user;

import com.shop.dao.BaseDao;
import com.shop.model.user.Customer;

/**
 * @author chenchen
 * @date 2018/10/25 14:37
 * @Content:
 */
public interface CustomerDao extends BaseDao<Customer> {
    public Customer login(String username, String password);
    public boolean isUnique(String username);

}
