<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
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
    <span class="wel_word">订单详情</span>
    <%@include file="../common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${requestScope.orderItemList}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.count}</td>
                <td>${item.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>

</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>