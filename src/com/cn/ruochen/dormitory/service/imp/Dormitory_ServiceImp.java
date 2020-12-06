package com.cn.ruochen.dormitory.service.imp;

import com.cn.ruochen.dormitory.dao.AdminDao;
import com.cn.ruochen.dormitory.dao.UserDao;
import com.cn.ruochen.dormitory.javaBean.pojo.Admin;
import com.cn.ruochen.dormitory.javaBean.pojo.User;
import com.cn.ruochen.dormitory.service.Dormitory_Service;

import java.util.List;

public class Dormitory_ServiceImp implements Dormitory_Service {

    /**
     * service 依赖于dao层操作数据库
     */
    AdminDao adminDao = new AdminDao();
    UserDao userDao = new UserDao();

    @Override
    public boolean register(Admin admin) {
        return adminDao.register(admin);
    }

    @Override
    public Admin login(Admin admin) {
       return adminDao.login(admin);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public boolean isExistByBedNumber(int bedNumber) {
        return userDao.isExistByBedNumber(bedNumber);
    }

    @Override
    public boolean isExistByUserId(String userId) {
        return userDao.isExistByUserId(userId);
    }
}
