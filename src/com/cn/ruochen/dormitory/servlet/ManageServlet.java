package com.cn.ruochen.dormitory.servlet;

import com.cn.ruochen.dormitory.javaBean.pojo.User;
import com.cn.ruochen.dormitory.service.Dormitory_Service;
import com.cn.ruochen.dormitory.service.imp.Dormitory_ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManageServlet extends HttpServlet {

    private Dormitory_Service service = new Dormitory_ServiceImp();
    HttpServletRequest request;
    HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;

        String method = request.getParameter("method");
        if (method.equals("add")) {
            this.add();
        }
        if (method.equals("userList")) {
            this.userList();
        }
        if (method.equals("update")) {
            this.update();
        }
    }

    private void update() throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = service.getUserById(Integer.parseInt(id));
        String user_sex = user.getUser_sex();
        request.setAttribute("user", user);
        request.getRequestDispatcher("dormitory_manage_jsp/update.jsp").forward(request, response);
    }

    private void userList() throws IOException, ServletException {
        List<User> userList = service.userList();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("dormitory_manage_jsp/userList.jsp").forward(request, response);
    }

    private void add() throws IOException {
        response.sendRedirect(request.getContextPath() + "/dormitory_manage_jsp/add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
