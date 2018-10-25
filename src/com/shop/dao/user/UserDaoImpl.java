package com.shop.dao.user;

import com.shop.dao.DaoSupport;
import com.shop.model.user.User;

import java.util.List;

/**
 * @author chenchen
 * @date 2018/10/25 15:12
 * @Content:
 */
public class UserDaoImpl extends DaoSupport<User> implements UserDao {
    @Override
    public User login(String username, String password) {
        if(username != null && password != null){//如果用户名和密码不为空
            String where = "where username=? and password=?";//设置查询条件
            Object[] queryParams = {username,password};//设置参数对象数组
            List<User> list = find(-1, -1, where, queryParams).getList();//执行查询方法
            if(list != null && list.size() > 0){//如果list集合不为空
                return list.get(0);//返回List中的第一个存储对象
            }
        }
        return null;//返回空值
    }

    @Override
    public boolean isUnique(String username) {
        List list = getTemplate().find("from User where username = ?", username);
        if(list != null && list.size() > 0){
            return false;
        }
        return true;
    }
}
