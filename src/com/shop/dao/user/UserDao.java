package com.shop.dao.user;

import com.shop.dao.BaseDao;
import com.shop.model.user.User;

/**
 * @author chenchen
 * @date 2018/10/25 15:10
 * @Content:
 */
public interface UserDao extends BaseDao <User> {
    public User login(String username, String password);

    public boolean isUnique(String username);
}
