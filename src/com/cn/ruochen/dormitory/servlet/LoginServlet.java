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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 获取参数
        String method;
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
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        JSONObject error = new JSONObject();

        String admin_name = request.getParameter("admin_name");
        String admin_pwd = request.getParameter("admin_pwd");
        Admin admin = new Admin();
        admin.setAdmin_name(admin_name);
        admin.setAdmin_pwd(admin_pwd);
        Admin admins = service.login(admin);
        if (admins == null) {
            error.put("errorMsg", "用户名或密码错误");
        }
        if (error.isEmpty()) {
            request.getSession().setAttribute("admin", admins);
            json.put("status", true);
        } else {
            json.put("status", false);
            json.put("error", error);
        }
        out.print(json);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
