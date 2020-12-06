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

<repid:override name="title">查询信息</repid:override>

<repid:override name="css">
    <style>
        .table-responsive {
            padding-left: 16px;
            padding-right: 16px;
            padding-top: 30px;
        }
    </style>
</repid:override>

<repid:override name="content">
    <form action="#" method="post">
        <!-- 自适应滚动条 -->
        <div class="table-responsive">
            <table class="table table-striped">
                <tr>
                    <td>#</td>
                    <td>床号</td>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>联系方式</td>
                    <td>地址</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.bed_number}</td>
                        <td>${user.user_id}</td>
                        <td>${user.user_name}</td>
                        <td>${user.user_sex}</td>
                        <td>${user.user_age}</td>
                        <td>${user.telephone}</td>
                        <td>${user.address}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Manage?method=update&id=${user.id}" type="button"
                               class="btn btn-info">修改</a>
                            <a type="button" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>
</repid:override>

<%@include file="layout/manage.jsp" %>
