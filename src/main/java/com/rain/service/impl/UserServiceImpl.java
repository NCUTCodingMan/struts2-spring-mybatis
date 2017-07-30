package com.rain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rain.dao.BaseDao;
import com.rain.entity.User;
import com.rain.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    public static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource(name = "baseDao")
    private BaseDao<User> baseDao;
    
    @Override
    public List<User> getUsersList() throws Exception {
        logger.debug("--- 查询数据库用户列表信息,并返回 ---");
        List<User> users = baseDao.queryForList("UserMapper.pageList", null);
        return users;
    }

    @Override
    public User getUserByUsernameAndPassword(User user) throws Exception {
        logger.debug("--- 根据用户名,密码查询用户列表信息,并返回 ---");
        return baseDao.queryForObject("UserMapper.getUserByUsernameAndPassword", user);
    }

    @Override
    public boolean editUserByUserId(Integer uId) throws Exception {
        logger.debug("--- 根据逐渐修改用户相关信息,并返回是否修改出现异常标志 ---");
        return baseDao.edit("UserMapper.editUserByUid", null);
    }
}
