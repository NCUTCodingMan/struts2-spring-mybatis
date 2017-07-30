package com.rain.service;

import java.util.List;

import com.rain.entity.User;

public interface UserService {
    public abstract List<User> getUsersList() throws Exception;
    public abstract User getUserByUsernameAndPassword(User user) throws Exception;
    public abstract boolean editUserByUserId(Integer uId) throws Exception;
}
