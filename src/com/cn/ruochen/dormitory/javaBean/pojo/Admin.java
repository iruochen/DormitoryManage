package com.cn.ruochen.dormitory.javaBean.pojo;

public class Admin {
    /**
     * 主键
     */
    private int id;
    /**
     * 管理员账号
     */
    private String admin_name;
    /**
     * 管理员密码
     */
    private String admin_pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                '}';
    }
}
