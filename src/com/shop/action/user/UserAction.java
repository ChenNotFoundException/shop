package com.shop.action.user;

import com.opensymphony.xwork2.ModelDriven;
import com.shop.action.BaseAction;
import com.shop.model.user.User;


/**
 * @author chenchen
 * @date 2018/10/25 15:01
 * @Content:
 */
public class UserAction extends BaseAction implements ModelDriven <User> {

    /**
     * 登录
     * @return
     * @throws Exception
     */
    public String logon() throws Exception{
        //验证用户名和密码
        User loginUser = userDao.login(user.getUsername(), user.getPassword());
        if(loginUser != null){//通过验证
            session.put("admin", loginUser);//将管理员信息保存在Session对象中
        }else{
            addFieldError("", "用户名或密码不正确！");//返回错误提示信息
            return USER_LOGIN;//返回后台登录页面
        }
        return MANAGER;//返回后台管理页面
    }
    /**
     * 退出
     * @return String
     * @throws Exception
     */
    public String logout() throws Exception{
        if(session != null && session.size() > 0){
            session.clear();
        }
        return INDEX;
    }
    // 用户对象
    private User user = new User();
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public User getModel() {
        return null;
    }
}
