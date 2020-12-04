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

public class UserServlet extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;
    Dormitory_Service service = new Dormitory_ServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String method = request.getParameter("method");
        if (method.equals("addUser")) {
            this.addUser();
        }
        if (method.equals("userList")) {
            this.userList();
        }
    }

    private void userList() throws ServletException, IOException {
        List<User> userList = service.userList();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("dormitory_manage_jsp/userList.jsp").forward(request, response);
    }

    private void addUser() throws IOException, ServletException {
        String bed_number = request.getParameter("bed_number");
        String user_id = request.getParameter("user_id");
        String user_name = request.getParameter("user_name");
        String user_sex = request.getParameter("user_sex");
        String user_age = request.getParameter("user_age");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        User user = new User();
        user.setBed_number(Integer.parseInt(bed_number));
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setUser_sex(user_sex);
        user.setUser_age(Integer.parseInt(user_age));
        user.setTelephone(telephone);
        user.setAddress(address);

        if (service.addUser(user)) {
            response.sendRedirect("UserServlet?method=userList");
        } else {
            request.setAttribute("errorMsg", "添加失败");
            request.getRequestDispatcher("UserServlet?method=addUser").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
