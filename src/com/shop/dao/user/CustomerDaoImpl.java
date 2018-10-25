package com.shop.dao.user;

import com.shop.dao.DaoSupport;
import com.shop.model.user.Customer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/25 15:03
 * @Content:
 */
public class CustomerDaoImpl extends DaoSupport <Customer> implements CustomerDao {


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Customer login(String username, String password) {
        if (username != null && password != null) {
            String where = "where username=? and password=?";
            Object[] queryParams = {username, password};
            List <Customer> list = find(-1, -1, where, queryParams).getList();
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
        }
        return null;
    }

    @Override
    public boolean isUnique(String username) {
        List list = getTemplate().find("from Customer where username = ?", username);
        if (list != null && list.size() > 0) {
            return false;
        }
        return true;
    }
}
