package com.shop.action.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shop.action.BaseAction;

import java.util.Map;

/**
 * @author chenchen
 * @date 2018/10/25 16:05
 * @Content: 消费者登录拦截器
 */
public class CustomerLoginInteceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = actionInvocation.getInvocationContext();
        Map<String,Object> session = context.getSession();
        if (session.get("customer") != null) {
            return actionInvocation.invoke();
        }
        return BaseAction.CUSTOMER_LOGIN;
    }
}
