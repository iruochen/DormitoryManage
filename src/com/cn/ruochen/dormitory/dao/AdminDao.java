package com.cn.ruochen.dormitory.dao;

import com.cn.ruochen.dormitory.javaBean.pojo.Admin;
import com.cn.ruochen.dormitory.utilts.JDBC_Utilts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    Connection conn = null;
    Statement state = null;
    PreparedStatement prepState = null;

    /**
     * 查询所有管理员信息
     *
     * @return 所有管理员信息列表
     */
    public List<Admin> adminList() {
        List<Admin> list = new ArrayList<>();
        conn = JDBC_Utilts.getConnection();
        ResultSet resultSet = null;
        try {
            state = conn.createStatement();
            String sql = "select * from admin";
            resultSet = state.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String admin_name = resultSet.getString("admin_name");
                String admin_pwd = resultSet.getString("admin_pwd");
                Admin admin = new Admin();
                admin.setId(id);
                admin.setAdmin_name(admin_name);
                admin.setAdmin_pwd(admin_pwd);
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(resultSet, state, conn);
        }
        return list;
    }

    /**
     * 验证登录
     *
     * @param admins Admin对象
     * @return 成功：Admin对象  失败：null
     */
    public Admin login(Admin admins) {
        conn = JDBC_Utilts.getConnection();
        String sql = "select * from admin where admin_name = ? and admin_pwd = ?";
        ResultSet resultSet = null;
        try {
            prepState = conn.prepareStatement(sql);
            prepState.setString(1, admins.getAdmin_name());
            prepState.setString(2, admins.getAdmin_pwd());
            resultSet = prepState.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String admin_name = resultSet.getString("admin_name");
                String admin_pwd = resultSet.getString("admin_pwd");
                Admin admin = new Admin();
                admin.setAdmin_name(admin_name);
                admin.setAdmin_pwd(admin_pwd);
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(resultSet, prepState, conn);
        }
        return null;
    }


    /**
     * 注册管理员
     *
     * @param admin Admin对象
     * @return 注册成功：true  注册失败：false
     */
    public boolean register(Admin admin) {
        conn = JDBC_Utilts.getConnection();
        String sql = "insert into admin (admin_name, admin_pwd) values (?, ?)";
        try {
            prepState = conn.prepareStatement(sql);
            prepState.setString(1, admin.getAdmin_name());
            prepState.setString(2, admin.getAdmin_pwd());
            int i = prepState.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            JDBC_Utilts.close(prepState, conn);
        }
        return false;
    }


    /**
     * 判断用户名是否已经存在
     * @param adminName
     * @return 已存在：true  未存在：false
     */
    public boolean isExistByAdminName(String adminName) {
        conn = JDBC_Utilts.getConnection();
        String sql = "select * from admin where admin_name = ?" + adminName;
        ResultSet resultSet = null;
        try {
            state = conn.createStatement();
            resultSet = state.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            return false;
        } finally {
            JDBC_Utilts.close(resultSet, state, conn);
        }
        return false;
    }
}

