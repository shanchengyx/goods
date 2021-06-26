<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <%@include file="../common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //添加商品到购物车
            $('.addToCart').click(function () {
                let goodsId = $(this).attr('goodsId');
                $.getJSON(
                    "${pageScope.basePath}cartServlet",
                    "action=add&id=" + goodsId,
                    function (data) {
                        $('.cartTotalCount').text('您的购物车中有' + data.totalCount + '件商品');
                        $('.cartLastName').text(data.lastName);
                    }
                );
            })
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">星星杂货店</span>
    <div>
        <%-- 如果用户还没有登录 --%>
        <c:if test="${empty sessionScope.user}">
            <a href="${pageScope.basePath}pages/user/login.jsp">登录</a> |
            <a href="${pageScope.basePath}pages/user/register.jsp">注册</a> &nbsp;&nbsp;
            <a href="${pageScope.basePath}pages/cart/cart.jsp">购物车</a>
        </c:if>
        <%-- 如果用户已经登录 --%>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临星星杂货店</span>
            <a href="${pageScope.basePath}pages/cart/cart.jsp">购物车</a>
            <a href="${pageScope.basePath}orderServlet?action=myOrders">我的订单</a>
            <a href="${pageScope.basePath}userServlet?action=logout">退出登录</a>&nbsp;&nbsp;
            <%-- 如果用户是管理员 --%>
            <c:if test="${sessionScope.isManager}">
                <a href="${pageScope.basePath}pages/manager/manager.jsp">后台管理</a>
            </c:if>
        </c:if>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="${pageScope.basePath}client/goodsServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice"/>
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <%-- 如果购物车为空 --%>
            <c:if test="${empty sessionScope.cart.items}">
                <span class="cartTotalCount"></span>
                <div>
                    最后加入的商品是 <span class="cartLastName" style="color: red">购物车为空</span>
                </div>
            </c:if>
            <%-- 如果购物车非空 --%>
            <c:if test="${not empty sessionScope.cart.items}">
                <span class="cartTotalCount">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                <div>
                    最后加入的商品是 <span class="cartLastName" style="color: red">${sessionScope.latestItem.name}</span>
                </div>
            </c:if>
        </div>

        <%-- 输出货物信息开始 --%>
        <c:forEach items="${requestScope.page.items}" var="goods">
            <div class="b_list">
                <div class="img_div">
                    <img class="goods_img" alt="" src="../..${goods.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">名称:</span>
                        <span class="sp2">${goods.name}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${goods.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${goods.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${goods.stock}</span>
                    </div>
                    <div class="book_add">
                        <button goodsId="${goods.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
        <%-- 输出货物信息结束 --%>
    </div>

    <%@include file="../common/page_nav.jsp" %>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>