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
<%--2552*1148--%>
<repid:override name="css">
<%--    <style>--%>
<%--        img {--%>
<%--            width: 100%;--%>
<%--        }--%>
<%--    </style>--%>
</repid:override>
<repid:override name="content">
    <div>
        <img src="${pageContext.request.contextPath}/dormitory_manage_jsp/img/index.png" alt="">
    </div>
</repid:override>

<%@ include file="layout/base.jsp" %>
