package com.cn.ruochen.dormitory.servlet;

import com.cn.ruochen.dormitory.javaBean.pojo.User;
import com.cn.ruochen.dormitory.service.Dormitory_Service;
import com.cn.ruochen.dormitory.service.imp.Dormitory_ServiceImp;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServlet extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;
    Dormitory_Service service = new Dormitory_ServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");
        if (method.equals("addUser")) {
            this.addUser();
        }
        if (method.equals("userList")) {
            this.userList();
        }
        if (method.equals("update")) {
           this.update();
        }
    }

    private void update() throws IOException {
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        JSONObject error = new JSONObject();

        String old_bed_number = request.getParameter("old_bed_number");
        String old_user_id = request.getParameter("old_user_id");
        int id = Integer.parseInt(request.getParameter("id"));
        String bed_number = request.getParameter("bed_number");
        String user_id = request.getParameter("user_id");
        String user_name = request.getParameter("user_name");
        String user_sex = request.getParameter("user_sex");
        String user_age = request.getParameter("user_age");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        User user = new User();
        user.setId(id);
        if (bed_number.length() <= 0) {
            error.put("bedNumberError", "床号不能为空");
        } else {
            user.setBed_number(Integer.parseInt(bed_number));
            if (!bed_number.equals(old_bed_number) && service.isExistByBedNumber(Integer.parseInt(bed_number))) {
                error.put("bedNumberError", "床号已存在");
            }
        }
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setUser_sex(user_sex);
        if (user_age.length() <= 0) {
            error.put("userAgeError", "年龄不能为空");
        } else {
            user.setUser_age(Integer.parseInt(user_age));
            if (Integer.parseInt(user_age) < 0 || Integer.parseInt(user_age) > 120) {
                error.put("userAgeError", "年龄不合法");
            }
        }
        user.setTelephone(telephone);
        user.setAddress(address);
        if (user_id == null || user_id.length() <= 0) {
            error.put("userIdError", "学生学号不能为空");
        } else if (!user_id.equals(old_user_id) &&  service.isExistByUserId(user_id)) {
            error.put("userIdError", "学号已存在");
        }
        if (user_name == null || user_name.length() <= 0) {
            error.put("userNameError", "学生姓名不能为空");
        }
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (telephone.length() != 11) {
            error.put("phoneError", "手机号位数不正确");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(telephone);
            if (!m.matches()) {
                error.put("phoneError", "手机号格式不正确");
            }
        }
        if (address == null || address.length() <= 0) {
            error.put("addressError", "地址不能为空");
        }
        if (error.isEmpty()) {
            service.updateUser(user);
            json.put("status", true);
        } else {
            json.put("status", false);
            json.put("error", error);
        }
        out.print(json);
        out.close();
    }

    private void userList() throws ServletException, IOException {
        List<User> userList = service.userList();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("dormitory_manage_jsp/userList.jsp").forward(request, response);
    }

    private void addUser() throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        JSONObject error = new JSONObject();

        String bed_number = request.getParameter("bed_number");
        String user_id = request.getParameter("user_id");
        String user_name = request.getParameter("user_name");
        String user_sex = request.getParameter("user_sex");
        String user_age = request.getParameter("user_age");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        User user = new User();
        if (bed_number.length() <= 0) {
            error.put("bedNumberError", "床号不能为空");
        } else {
            user.setBed_number(Integer.parseInt(bed_number));
            if (service.isExistByBedNumber(Integer.parseInt(bed_number))) {
                error.put("bedNumberError", "床号已存在");
            }
        }
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setUser_sex(user_sex);
        if (user_age.length() <= 0) {
            error.put("userAgeError", "年龄不能为空");
        } else {
            user.setUser_age(Integer.parseInt(user_age));
            if (Integer.parseInt(user_age) < 0 || Integer.parseInt(user_age) > 120) {
                error.put("userAgeError", "年龄不合法");
            }
        }
        user.setTelephone(telephone);
        user.setAddress(address);
        if (user_id == null || user_id.length() <= 0) {
            error.put("userIdError", "学生学号不能为空");
        } else if (service.isExistByUserId(user_id)) {
            error.put("userIdError", "学号已存在");
        }
        if (user_name == null || user_name.length() <= 0) {
            error.put("userNameError", "学生姓名不能为空");
        }
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (telephone.length() != 11) {
            error.put("phoneError", "手机号位数不正确");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(telephone);
            if (!m.matches()) {
                error.put("phoneError", "手机号格式不正确");
            }
        }
        if (address == null || address.length() <= 0) {
            error.put("addressError", "地址不能为空");
        }
        if (error.isEmpty()) {
            service.addUser(user);
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
