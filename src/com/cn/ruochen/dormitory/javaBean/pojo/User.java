package com.cn.ruochen.dormitory.javaBean.pojo;

public class User {
    /**
     * 主键
     */
    private int id;
    /**
     * 床位
     */
    private int bed_number;
    /**
     * 学号
     */
    private String user_id;
    /**
     * 学生姓名
     */
    private String user_name;
    /**
     * 性别
     */
    private String user_sex;
    /**
     * 年龄
     */
    private int user_age;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 地址
     */
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBed_number() {
        return bed_number;
    }

    public void setBed_number(int bed_number) {
        this.bed_number = bed_number;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bed_number=" + bed_number +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_age=" + user_age +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
