<%--
  Created by IntelliJ IDEA.
  User: XiAng
  Date: 2021/5/26
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%-- 如果已经是首页了，就不显示 --%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${pageScope.basePath}${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${pageScope.basePath}${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%-- 输出页码开始 --%>
    <c:choose>
        <%-- 1.总页码少于5 --%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>
        <%-- 1.总页码大于5 --%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%-- 当前页码小于5 --%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <%-- 当前页码为最后3个 --%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <%-- 其他情况 --%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%-- 显示页码 --%>
    <c:forEach begin="${begin}" end="${end}" var="i">
    <c:if test="${i == requestScope.page.pageNo}">
    <a href="${pageScope.basePath}${requestScope.page.url}&pageNo=${i}">【${i}】<a/>
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
        <a href="${pageScope.basePath}${requestScope.page.url}&pageNo=${i}">${i}<a/>
            </c:if>
            </c:forEach>
            <%-- 输出页码结束 --%>

            <%-- 如果已经是末页了，就不显示 --%>
            <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="${pageScope.basePath}${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
            <a href="${pageScope.basePath}${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
            </c:if>
            共${requestScope.page.pageTotal}页，${requestScope.page.count}条记录 到第<input value="${requestScope.page.pageNo}"
                                                                                    name="pn" id="pn_input"/>页
            <input id="searchPageBtn" type="button" value="确定">
            <script type="text/javascript">
                $(function () {
                    $("#searchPageBtn").click(function () {
                        let pageNo = $("#pn_input").val();
                        if (pageNo > 0 && pageNo <= ${requestScope.page.pageTotal}) {
                            location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
                        } else {
                            return false;
                        }
                    });
                });
            </script>
</div>