package com.shop.action.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shop.action.BaseAction;

import java.util.Map;

/**
 * @author chenchen
 * @date 2018/10/25 16:08
 * @Content:
 */
public class UserLoginInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = actionInvocation.getInvocationContext();
        Map<String,Object> session = context.getSession();
        if (session.get("admin") != null) {
            return actionInvocation.invoke();
        }
        return BaseAction.USER_LOGIN;
    }
}
