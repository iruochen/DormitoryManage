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

<repid:override name="js">
    <script>
        function showDeleteModal(obj) {
            var $tds = $(obj).parent().parent().children();  // 获取所有列
            var delete_id = $($tds[0]).children("input").val()  // 获取隐藏的id
            $("#deleteId").val(delete_id);  // 将模态对话框需要修改的id设置为删除的id
        }

        $(function () {
            $("#btnDelete").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/UserServlet?method=delete",
                    type: "get",
                    data: "id=" + $("#deleteId").val(),
                    dataType: "JSON",
                    success: function (result) {
                        var res = eval(result);
                        if (res.status) {
                            location.href = location.href;
                        }
                    }
                });
            });
        });
    </script>

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
                        <td style="display: none">
                            <input type="hidden" value="${user.id}">
                        </td>
                        <td>${user.id}</td>
                        <td>${user.bed_number}</td>
                        <td>${user.user_id}</td>
                        <td>${user.user_name}</td>
                        <td>${user.user_sex}</td>
                        <td>${user.user_age}</td>
                        <td>${user.telephone}</td>
                        <td>${user.address}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Manage?method=update&id=${user.id}"
                               type="button"
                               class="btn btn-info">修改</a>
                            <a type="button" class="btn btn-danger" data-toggle="modal" data-target="#delModal"
                               href="javascript:void(0)" onclick="showDeleteModal(this)">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>


    <div class="modal fade" id="delModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="alert alert-danger alert-dismissable fade in" role="alert">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">是否要确定删除？</h4>
                <div class="modal-body">
                    <input type="hidden" id="deleteId">
                </div>
                <p style="text-align: right;">
                    <button class="btn btn-default btn-sm" data-dismiss="modal" aria-label="Close">取 消</button>
                    <button id="btnDelete" type="button" class="btn btn-danger btn-sm">确 定</button>
                </p>
            </div>
        </div>
    </div>
</repid:override>

<%@include file="layout/manage.jsp" %>
