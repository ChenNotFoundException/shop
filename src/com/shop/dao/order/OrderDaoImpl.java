package com.shop.dao.order;

import com.shop.dao.DaoSupport;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/25 15:17
 * @Content:
 */
public class OrderDaoImpl extends DaoSupport<Order> implements OrderDao {
    @Override
    public Order findByCustomer(int customerId) {
        String where = "where customer.id = ?";
        Object[] queryParams = {customerId};
        List<Order> list = find(-1, -1, where, queryParams).getList();
        return list.get(0);
    }
}
