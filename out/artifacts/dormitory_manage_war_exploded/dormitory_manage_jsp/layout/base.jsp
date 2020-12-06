<%--
  Created by IntelliJ IDEA.
  User: 若尘
  Date: 2020/11/30
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="repid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
    <head>
        <title><repid:block name="title"></repid:block></title>
        <link rel="stylesheet" href="<%=path%>/dormitory_manage_jsp/plugin/bootstrap/css/bootstrap.min.css"
              type="text/css">
        <link rel="stylesheet" href="<%=path%>/dormitory_manage_jsp/plugin/font-awesome/css/font-awesome.min.css"
              type="text/css">
        <!-- JQuery -->
        <script src="<%=path%>/dormitory_manage_jsp/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="<%=path%>/dormitory_manage_jsp/plugin/bootstrap/js/bootstrap.min.js"
                type="text/javascript"></script>
        <style>
            .navbar-default {
                border-radius: 0;
            }
        </style>
        <repid:block name="css"></repid:block>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=path%>/dormitory_manage_jsp/index.jsp">Index</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <!-- 已登录 -->
                        <c:if test="${sessionScope.admin != null}">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-haspopup="true"
                                   aria-expanded="false">${admin.admin_name}<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="<%=path%>/Manage?method=userList">管理中心</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="<%=path%>/Login?method=escSession">退 出</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <!-- 未登录 -->
                        <c:if test="${sessionScope.admin == null}">
                            <li><a href="<%=path%>/dormitory_manage_jsp/login.jsp">登 录</a></li>
                            <li><a href="<%=path%>/dormitory_manage_jsp/register.jsp">注 册</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

        <repid:block name="content"></repid:block>

        <repid:block name="js"></repid:block>
    </body>
</html>
