<%--
  Created by IntelliJ IDEA.
  User: 若尘
  Date: 2020/12/1
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="repid" uri="http://www.rapid-framework.org.cn/rapid" %>
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
        <link rel="stylesheet" href="<%=path%>/dormitory_manage_jsp/css/manage.css">
        <repid:block name="css"></repid:block>
        <style>
            .navbar-av {
                border-radius: 0;
            }

            .error-msg {
                color: red;
                position: absolute;
                font-size: 13px;
            }
        </style>

        <script src="<%=path%>/dormitory_manage_jsp/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="<%=path%>/dormitory_manage_jsp/plugin/bootstrap/js/bootstrap.min.js"
                type="text/javascript"></script>
        <repid:block name="js"></repid:block>
    </head>
    <body>
        <nav class="navbar navbar-av">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=path%>/Manage?method=userList">Manage</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="<%=path%>/Manage?method=userList">查询</a></li>
                        <li><a href="<%=path%>/Manage?method=add">添加</a></li>
<%--                        <li><a href="<%=path%>/Manage?method=update">修改</a></li>--%>
<%--                        <li><a href="<%=path%>/Manage?method=delete">删除</a></li>--%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <%--                        <li><a href="#"></a></li>--%>
                        <%--                        <li><a href="#"></a></li>--%>
                        <%--                        <li><a href="#"><i class="fa fa-bell-o" aria-hidden="true"></i> </a></li>--%>
                        <%--                        <li><a href="#"><i class="fa fa-question-circle-o" aria-hidden="true"></i> </a></li>--%>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true"
                               aria-expanded="false">${admin.admin_name}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path%>/dormitory_manage_jsp/index.jsp">官 网</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="<%=path%>/Login?method=escSession">退 出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <repid:block name="content"></repid:block>

    </body>
</html>
