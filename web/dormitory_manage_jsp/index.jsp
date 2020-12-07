<%--
  Created by IntelliJ IDEA.
  User: 若尘
  Date: 2020/11/30
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="repid" uri="http://www.rapid-framework.org.cn/rapid" %>
<repid:override name="title">首页</repid:override>
<repid:override name="css">
    <style>
        img {
            width: 100%;
            height: 90%;
        }

        #footer {
            height: 40px;
            line-height: 40px;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            background: #333;
            color: #fff;
            font-family: Arial;
            font-size: 12px;
            letter-spacing: 1px;
        }
    </style>
</repid:override>
<repid:override name="content">
    <div>
        <img src="${pageContext.request.contextPath}/dormitory_manage_jsp/img/index.png" alt="图片加载失败">
    </div>
    <dlv id="footer">
        ©2020 Ruo Chen. All rights reserved.
    </dlv>
</repid:override>

<%@ include file="layout/base.jsp" %>
