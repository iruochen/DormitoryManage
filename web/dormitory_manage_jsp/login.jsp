<%--
  Created by IntelliJ IDEA.
  User: 若尘
  Date: 2020/11/30
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="repid" uri="http://www.rapid-framework.org.cn/rapid" %>

<repid:override name="title"> 用户登录 </repid:override>
<repid:override name="css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dormitory_manage_jsp/css/account.css">
    <style>
        .error-msg {
            color: red;
            position: absolute;
            font-size: 13px;
        }
    </style>
    <repid:override name="js">
        <script>
            // 页面框架加载完后自动执行
            $(function () {
                bindClickSubmit();
            });

            function bindClickSubmit() {
                $('#btnSubmit').click(function () {
                    $('.error-msg').empty();

                    $.ajax({
                        url: "${pageContext.request.contextPath}/Login",
                        type: "post",
                        data: $('#loginForm').serialize(),
                        dataType: "JSON",
                        success: function (result) {
                            var res = eval(result);
                            if (res.status) {
                                // alert("登录成功");
                                window.location = "${pageContext.request.contextPath}/dormitory_manage_jsp/index.jsp";
                            } else {
                                $.each(res.error, function (k, v) {
                                    $('#' + k).text(v);
                                });
                            }
                        }, error: function () {
                            location.href = "${pageContext.request.contextPath}/dormitory_manage_jsp/login.jsp";
                        }
                    })
                });
            }
        </script>
    </repid:override>
</repid:override>

<repid:override name="content">
    <div class="account">
        <div class="title">用户登录</div>
        <form id="loginForm" method="post">
            <input type="hidden" name="method" value="index">
            <div class="form-group">
                <label>用户名</label>
                <input type="text" class="form-control" name="admin_name" placeholder="请输入用户名">
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password" class="form-control" name="admin_pwd" placeholder="请输入密码">
                <span id="errorMsg" class="error-msg"></span>
            </div>
            <input id="btnSubmit" type="button" class="btn btn-primary" value="登录">
        </form>
    </div>
</repid:override>
<%@ include file="layout/base.jsp" %>
