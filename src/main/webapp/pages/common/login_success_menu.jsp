<%--
  Created by IntelliJ IDEA.
  User: XiAng
  Date: 2021/5/23
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:choose>
        <%-- 如果没有登录 --%>
        <c:when test="${empty sessionScope.user}">
            <a href="${pageScope.basePath}pages/user/login.jsp">登录</a> |
            <a href="${pageScope.basePath}pages/user/register.jsp">注册</a> &nbsp;&nbsp;
            <a href="${pageScope.basePath}">主页</a>
        </c:when>
        <%-- 如果已经登录 --%>
        <c:when test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临星星杂货店</span>
            <a href="${pageScope.basePath}orderServlet?action=myOrders">我的订单</a>
            <a href="${pageScope.basePath}userServlet?action=logout">退出登录</a>&nbsp;&nbsp;
            <a href="${pageScope.basePath}">主页</a>
        </c:when>
    </c:choose>
</div>
