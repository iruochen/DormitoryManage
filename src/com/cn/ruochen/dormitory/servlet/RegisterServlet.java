package com.cn.ruochen.dormitory.servlet;

import com.cn.ruochen.dormitory.javaBean.pojo.Admin;
import com.cn.ruochen.dormitory.service.Dormitory_Service;
import com.cn.ruochen.dormitory.service.imp.Dormitory_ServiceImp;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注册 Servlet
 */
public class RegisterServlet extends HttpServlet {
    private Dormitory_Service service = new Dormitory_ServiceImp();
    HttpServletRequest request;
    HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        // 处理乱码问题
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        this.register();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    private void register() throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        JSONObject error = new JSONObject();

        String admin_name = request.getParameter("admin_name");
        String admin_pwd = request.getParameter("admin_pwd");
        String confirm_pwd = request.getParameter("confirm_pwd");
        Admin admin = new Admin();
        admin.setAdmin_name(admin_name);
        admin.setAdmin_pwd(admin_pwd);
        // 能否插入成功
        if (admin_pwd == null || admin_pwd.length() <= 0) {
            error.put("pwdNullError", "密码不能为空");
        }
        // 确认密码与密码是否一致
        if (!admin_pwd.equals(confirm_pwd)) {
            error.put("confirmError", "两次输入密码不一致");
        } else {
            if (!service.register(admin) || (admin_name == null || admin_name.length() <= 0)) {
                error.put("existError", "用户名已存在或为空");
            }
        }
        if (error.isEmpty()) {
            json.put("status", true);
        } else {
            json.put("status", false);
            json.put("error", error);
        }
        out.print(json);
        out.close();
    }
}
