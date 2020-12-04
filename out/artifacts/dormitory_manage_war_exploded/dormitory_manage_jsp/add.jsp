<%--
  Created by IntelliJ IDEA.
  User: 若尘
  Date: 2020/12/1
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="repid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<repid:override name="title">添加信息</repid:override>

<repid:override name="css">
    <style>
        .add {
            margin-top: 30px;
        }

        .add .title {
            font-size: 25px;
            font-weight: bold;
            text-align: center;
        }

        .error-msg {
            color: red;
            position: absolute;
            font-size: 13px;
        }
    </style>
</repid:override>

<repid:override name="content">
    <form class="form-horizontal add" action="${pageContext.request.contextPath}/UserServlet" method="get">
        <input type="hidden" name="method" value="addUser">
        <div class="title" style="margin-bottom: 20px"> 添加信息</div>
        <div class="form-group">
            <label class="col-sm-2 control-label">床号</label>
            <div class="col-sm-8">
                <input type="number" class="form-control" name="bed_number" placeholder="请输入床号" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学号</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="user_id" placeholder="请输入学号" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="user_name" placeholder="请输入姓名" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-8">
                    <%--                <input type="text" class="form-control" name="user_sex" placeholder="请输入性别">--%>
                <select class="form-control" name="user_sex">
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-8">
                <input type="number" class="form-control" name="user_age" placeholder="请输入年龄" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">联系方式</label>
            <div class="col-sm-8">
                <input type="number" class="form-control" name="telephone" placeholder="请输入联系方式" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">地址</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" name="address" placeholder="请输入地址" required>
            </div>
        </div>
        <c:if test="${errorMsg != null}">
            <span class="error-msg">
                    ${errorMsg}
            </span>
        </c:if>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添加</button>
            </div>
        </div>
    </form>
</repid:override>

<%@include file="layout/manage.jsp" %>
