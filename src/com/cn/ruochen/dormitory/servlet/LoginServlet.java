package com.cn.ruochen.dormitory.servlet;

import com.cn.ruochen.dormitory.javaBean.pojo.Admin;
import com.cn.ruochen.dormitory.service.Dormitory_Service;
import com.cn.ruochen.dormitory.service.imp.Dormitory_ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录 Servlet
 */
public class LoginServlet extends HttpServlet {

    private Dormitory_Service service = new Dormitory_ServiceImp();
    HttpServletRequest request;
    HttpServletResponse response;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        // 获取参数
        String method = null;
        method = request.getParameter("method");
        if (method.equals("escSession")) {
            this.escSession();
        }
        if (!method.equals("escSession")) {
            this.login();
        }
    }

    private void escSession() throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/dormitory_manage_jsp/index.jsp");
    }

    private void login() throws IOException, ServletException {
        String admin_name = request.getParameter("admin_name");
        String admin_pwd = request.getParameter("admin_pwd");
        Admin admin = new Admin();
        admin.setAdmin_name(admin_name);
        admin.setAdmin_pwd(admin_pwd);
        Admin admins = service.login(admin);
        if (admins != null) {
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect(request.getContextPath() + "/dormitory_manage_jsp/index.jsp");
        } else {
            request.setAttribute("errorMsg", "用户名或密码错误");
            request.getRequestDispatcher("dormitory_manage_jsp/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
