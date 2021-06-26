<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
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
    <span class="wel_word">后台管理系统</span>
    <div>
        <a href="${pageScope.basePath}manager/goodsServlet?action=page">货物管理</a>
        <a href="${pageScope.basePath}orderServlet?action=allOrders">订单管理</a>
        <a href="${pageScope.basePath}">返回店铺</a>
    </div>
</div>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>