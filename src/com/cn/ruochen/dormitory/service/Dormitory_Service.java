package com.cn.ruochen.dormitory.service;

import com.cn.ruochen.dormitory.javaBean.pojo.Admin;
import com.cn.ruochen.dormitory.javaBean.pojo.User;

import java.util.List;

public interface Dormitory_Service {
    boolean register(Admin admin);

    Admin login(Admin admin);

    boolean addUser(User user);

    List<User> userList();
}
