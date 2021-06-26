<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑货物</title>
    <%@include file="../common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.jpg">
    <span class="wel_word">编辑货物</span>
    <div>
        <a href="${pageScope.basePath}manager/goodsServlet?action=page">货物管理</a>
        <a href="${pageScope.basePath}pages/manager/order_manager.jsp">订单管理</a>
        <a href="${pageScope.basePath}index.jsp">返回店铺</a>
    </div>
</div>

<div id="main">
    <form action="${pageScope.basePath}manager/goodsServlet" method="post">
        <input type="hidden" name="action" value="${param.method}"/>
        <input type="hidden" name="id" value="${requestScope.goods.id}"/>
        <input type="hidden" name="pageNo" value="${param.pageNo}"/>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.goods.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.goods.price}"/></td>
                <td><input name="sales" type="text" value="${requestScope.goods.sales}"></td>
                <td><input name="stock" type="text" value="${requestScope.goods.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>