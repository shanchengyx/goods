package com.gyx.web;

import com.gyx.pojo.Goods;
import com.gyx.pojo.Page;
import com.gyx.service.GoodsService;
import com.gyx.service.impl.GoodsServiceImpl;
import com.gyx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理商品的servlet
 */
public class ClientGoodsServlet extends BaseServlet {
    GoodsService goodsService = new GoodsServiceImpl();

    /**
     * 分页
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Goods> page = goodsService.page(pageNo, pageSize);
        page.setUrl("client/goodsServlet?action=page");//给page设置url
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    /**
     * 按价格分页
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        Page<Goods> page = goodsService.pageByPrice(pageNo, pageSize, min, max);
        page.setUrl("client/goodsServlet?action=pageByPrice&min=" + min + "&max=" + max);//给page设置url
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
