package com.shop.dao.order;

import com.shop.dao.BaseDao;
import org.hibernate.criterion.Order;

/**
 * @author chenchen
 * @date 2018/10/25 15:16
 * @Content:
 */
public interface OrderDao extends BaseDao<Order> {
    public Order findByCustomer(int customerId);
}
