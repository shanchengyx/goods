<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%@include file="../common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">我的订单</span>
    <%@include file="../common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>操作</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.orderList}" var="order">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td>
                    <c:if test="${order.status == 0}">
                        未发货
                    </c:if>
                    <c:if test="${order.status == 1}">
                        已发货
                    </c:if>
                    <c:if test="${order.status == 2}">
                        已签收
                    </c:if>
                </td>
                <td>
                    <c:if test="${order.status == 1}">
                        <a href="${pageScope.basePath}orderServlet?action=receiveOrder&orderId=${order.orderId}">签收</a>
                    </c:if>
                </td>
                <td><a href="${pageScope.basePath}orderServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>