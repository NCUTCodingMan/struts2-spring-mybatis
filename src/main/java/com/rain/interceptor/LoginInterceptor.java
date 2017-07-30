package com.rain.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.rain.action.LoginAction;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        
        // 若当前判断是登录操作,直接放行
        if (invocation.getAction().getClass() == LoginAction.class) {
            return invocation.invoke();
        }
        
        // 若是其他操作,需要判断session中是否有用户登录信息
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        if (session.get("user") == null) {
            return Action.LOGIN;
        }
        
        return invocation.invoke();
    }
}
