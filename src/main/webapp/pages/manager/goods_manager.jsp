<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>货物管理</title>
    <%@include file="../common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("确认要删除[" + $(this).parent().parent().find("td:first").text() + "]吗");
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">货物管理系统</span>
    <div>
        <a href="${pageScope.basePath}manager/goodsServlet?action=page">货物管理</a>
        <a href="${pageScope.basePath}orderServlet?action=allOrders">订单管理</a>
        <a href="${pageScope.basePath}">返回店铺</a>
    </div>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="goods">
            <tr>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>${goods.sales}</td>
                <td>${goods.stock}</td>
                <td>
                    <a href="${pageScope.basePath}manager/goodsServlet?method=update&action=getGoods&id=${goods.id}&pageNo=${requestScope.page.pageNo}">修改</a>
                </td>
                <td><a class="deleteClass"
                       href="${pageScope.basePath}manager/goodsServlet?action=delete&id=${goods.id}&pageNo=${requestScope.page.pageNo}">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <a href="${pageScope.basePath}/pages/manager/goods_edit.jsp?method=add&pageNo=${requestScope.page.pageNo}">添加货物</a>
            </td>
        </tr>
    </table>

    <%@include file="../common/page_nav.jsp" %>

</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>