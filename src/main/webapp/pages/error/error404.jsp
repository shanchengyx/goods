<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>要访问的页面不存在，非常抱歉</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">星星杂货店</span>
</div>
<div id="main">
    <div id="book">
        要访问的页面不存在，非常抱歉<br/>
        <a href="${pageScope.basePath}">点此返回首页</a>
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>