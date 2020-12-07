package com.cn.ruochen.dormitory.dao;

import com.cn.ruochen.dormitory.javaBean.pojo.User;
import com.cn.ruochen.dormitory.utilts.JDBC_Utilts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    Connection conn = null;
    Statement state = null;
    PreparedStatement prepState = null;

    /**
     * 添加用户
     *
     * @param user User 对象
     * @return 添加成功：true  添加失败：false
     */
    public boolean addUser(User user) {
        conn = JDBC_Utilts.getConnection();
        String sql = "insert into user (bed_number, user_id, user_name, user_sex, user_age, telephone, address) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            prepState = conn.prepareStatement(sql);
            prepState.setInt(1, user.getBed_number());
            prepState.setString(2, user.getUser_id());
            prepState.setString(3, user.getUser_name());
            prepState.setString(4, user.getUser_sex());
            prepState.setInt(5, user.getUser_age());
            prepState.setString(6, user.getTelephone());
            prepState.setString(7, user.getAddress());
            int i = prepState.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(prepState, conn);
        }
        return false;
    }


    /**
     * 获取所有用户列表
     *
     * @return 所有用户列表
     */
    public List<User> userList() {
        List<User> list = new ArrayList<>();
        conn = JDBC_Utilts.getConnection();
        ResultSet resultSet = null;
        String sql = "select * from user";
        try {
            state = conn.createStatement();
            resultSet = state.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int bed_number = resultSet.getInt("bed_number");
                String user_id = resultSet.getString("user_id");
                String user_name = resultSet.getString("user_name");
                String user_sex = resultSet.getString("user_sex");
                int user_age = resultSet.getInt("user_age");
                String telephone = resultSet.getString("telephone");
                String address = resultSet.getString("address");

                User user = new User();
                user.setId(id);
                user.setBed_number(bed_number);
                user.setUser_id(user_id);
                user.setUser_name(user_name);
                user.setUser_sex(user_sex);
                user.setUser_age(user_age);
                user.setTelephone(telephone);
                user.setAddress(address);

                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(resultSet, prepState, conn);
        }
        return list;
    }


    /**
     * id 查询
     * @param id id值
     * @return User用户
     */
    public User getUserById(int id) {
        User user = null;
        conn = JDBC_Utilts.getConnection();
        String sql = "select * from user where id = ?";
        ResultSet resultSet = null;
        try {
            prepState = conn.prepareStatement(sql);
            prepState.setInt(1, id);
            resultSet = prepState.executeQuery();
            if (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                int bed_number = resultSet.getInt("bed_number");
                String user_id = resultSet.getString("user_id");
                String user_name = resultSet.getString("user_name");
                String user_sex = resultSet.getString("user_sex");
                int user_age = resultSet.getInt("user_age");
                String telephone = resultSet.getString("telephone");
                String address = resultSet.getString("address");

                user = new User();
                user.setId(id1);
                user.setBed_number(bed_number);
                user.setUser_id(user_id);
                user.setUser_name(user_name);
                user.setUser_sex(user_sex);
                user.setUser_age(user_age);
                user.setTelephone(telephone);
                user.setAddress(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(resultSet, prepState, conn);
        }
        return user;
    }

    /**
     * 根据UserId 判断用户是否已经存在
     * @param userId 学号
     * @return 已存在：true  不存在：false
     */
    public boolean isExistByUserId(String userId) {
        conn = JDBC_Utilts.getConnection();
        String sql = "select * from user where user_id = " + userId;
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

    /**
     * 根据BedNumber 判断用户是否已经存在
     * @param bedNumber 床号
     * @return 已存在：true  不存在：false
     */
    public boolean isExistByBedNumber(int bedNumber) {
        conn = JDBC_Utilts.getConnection();
        String sql = "select * from user where bed_number = " + bedNumber;
        ResultSet resultSet = null;
        try {
            state = conn.createStatement();
            resultSet = state.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            return false;
        }  finally {
            JDBC_Utilts.close(resultSet, state, conn);
        }
        return false;
    }

    /**
     * 更新数据
     * @param user User 对象
     * @return 更新成功：true  更新失败：false
     */
    public boolean updateUser(User user) {
        conn = JDBC_Utilts.getConnection();
        String sql = "update user set bed_number = ?, user_id = ?, user_name = ?, user_sex = ?, user_age = ?, telephone = ?, address = ? where id = ?";
        try {
            prepState = conn.prepareStatement(sql);
            prepState.setInt(1, user.getBed_number());
            prepState.setString(2, user.getUser_id());
            prepState.setString(3, user.getUser_name());
            prepState.setString(4, user.getUser_sex());
            prepState.setInt(5, user.getUser_age());
            prepState.setString(6, user.getTelephone());
            prepState.setString(7, user.getAddress());
            prepState.setInt(8, user.getId());
            int i = prepState.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(prepState, conn);
        }
        return false;
    }


    /**
     * 删除数据
     * @param id id值
     * @return 删除成功：true  删除失败：false
     */
    public boolean deleteUser(int id) {
        conn = JDBC_Utilts.getConnection();
        String sql = "delete from user where id = ?";
        try {
            prepState = conn.prepareStatement(sql);
            prepState.setInt(1, id);
            int i = prepState.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Utilts.close(prepState, conn);
        }
        return false;
    }

}
