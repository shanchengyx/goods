<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="../common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //添加删除商品的确认提示
            $('a.deleteItem').click(function () {
                return confirm('确定要删除[' + $(this).parent().parent().find('td:first').text() + ']吗');
            });

            //添加清空购物车的确认提示
            $('#clearCart').click(function () {
                return confirm('确定要清空购物车吗');
            });

            $('.updateCount').change(function () {
                if (confirm('确定要修改[' + $(this).parent().parent().find('td:first').text() + ']的数量为[' + $(this).val() + ']吗')) {
                    location.href = '${pageScope.basePath}cartServlet?action=update&id=' + $(this).attr('goodsId') + '&count=' + $(this).val();
                } else {
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">购物车</span>
    <%@include file="../common/login_success_menu.jsp" %>
    <script type="text/javascript">
        $(function () {
            $('#checkout').click(function () {
                if (${empty sessionScope.user}) {
                    alert('您还没有登录，请先登录再结算');
                    return false;
                }
            });
        });
    </script>
</div>

<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <%-- 如果购物车为空 --%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="${pageScope.basePath}">购物车空了，快去寻找宝贝吧！</a></td>
            </tr>
        </c:if>
        <%-- 如果购物车非空 --%>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" goodsId="${entry.value.id}" type="text" value="${entry.value.count}"
                               style="width: 80px;"/>
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.count * entry.value.price}</td>
                    <td><a class="deleteItem"
                           href="${pageScope.basePath}cartServlet?action=delete&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <%-- 购物车非空才输出结算栏 --%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart"
                                       href="${pageScope.basePath}cartServlet?action=clear">清空购物车</a></span>
            <span id="checkout" class="cart_span"><a href="${pageScope.basePath}orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>