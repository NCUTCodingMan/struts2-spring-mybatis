package com.rain.entity;

public class User {
    private Integer uId;
    private String username;
    private String password;
    private Integer age;

    public User(){}

    public User(Integer uId, String username, String password, Integer age) {
        super();
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Integer getuId() {
        return uId;
    }
    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", age=" + age + "]";
    }
}
