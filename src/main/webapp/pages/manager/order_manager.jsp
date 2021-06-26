<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">订单管理系统</span>
    <div>
        <a href="${pageScope.basePath}manager/goodsServlet?action=page">货物管理</a>
        <a href="${pageScope.basePath}orderServlet?action=allOrders">订单管理</a>
        <a href="${pageScope.basePath}">返回店铺</a>
    </div>
</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>发货</td>

        </tr>
        <c:forEach items="${requestScope.orderList}" var="order">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td><a href="${pageScope.basePath}orderServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a>
                </td>
                <td>
                    <c:if test="${order.status == 0}">
                        <a href="${pageScope.basePath}orderServlet?action=sendOrder&orderId=${order.orderId}">点击发货</a>
                    </c:if>
                    <c:if test="${order.status == 1}">
                        已发货
                    </c:if>
                    <c:if test="${order.status == 2}">
                        买家已签收
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>