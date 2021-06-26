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
 * 对货物进行处理的Servlet
 */
public class GoodsServlet extends BaseServlet {
    GoodsService service = new GoodsServiceImpl();

    /**
     * 添加货物
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods goods = WebUtils.copyParamToBean(new Goods(), request.getParameterMap());
        service.addGoods(goods);
        response.sendRedirect(BASE_PATH + "manager/goodsServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 删除货物
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.deleteGoodsById(Integer.parseInt(id));
        response.sendRedirect(BASE_PATH + "manager/goodsServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 更新货物信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods goods = WebUtils.copyParamToBean(new Goods(), request.getParameterMap());
        service.updateGoods(goods);
        response.sendRedirect(BASE_PATH + "manager/goodsServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 根据id获取单个货物信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Goods goods = service.queryGoodsById(Integer.parseInt(id));
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("/pages/manager/goods_edit.jsp").forward(request, response);
    }

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
        Page<Goods> page = service.page(pageNo, pageSize);
        page.setUrl("manager/goodsServlet?action=page");//给page设置url
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(request, response);
    }
}
