package com.rain.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;
import com.rain.entity.User;
import com.rain.service.UserService;

// 每次请求获取的是不同的实例对象(这一点和一般spring注入的对象有所不同(singleton))
@Controller
@Scoped(value = Scope.PROTOTYPE)
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
    public static Logger logger = LoggerFactory.getLogger(LoginAction.class);
    private User user;
    @Resource(name = "userService")
    private UserService userService;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    // 在设置自定义方式时,方法的样式(返回值,形参,异常需要与execute()方法一致),只有这样才能找Action类中到相关的方法
    public String login() throws Exception {
        logger.debug("--- 检测session中是否包含用户登录信息 ---");
        User user = userService.getUserByUsernameAndPassword(this.user);
        if (user == null) {
            logger.debug("--- 用户名密码错误,跳转登录界面 ---");
            return LOGIN;
        }
        logger.debug("--- 用户名密码正确,跳转首页 ---");
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("user", user);
        return SUCCESS;
    }   
}