package com.gyx.web;

import com.gyx.pojo.Cart;
import com.gyx.pojo.Order;
import com.gyx.pojo.OrderItem;
import com.gyx.pojo.User;
import com.gyx.service.OrderService;
import com.gyx.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 处理订单信息的Servlet
 */
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    /**
     * 创建订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        //如果购物车或用户信息为空，重定向回购物车
        if (cart == null || user == null) {
            response.sendRedirect(BASE_PATH + "pages/cart/cart.jsp");
        }
        //创建订单
        String orderId = orderService.createOrder(cart, user.getId());
        //清空购物车
        cart.clear();
        //重定向到结算页面
        response.sendRedirect(BASE_PATH + "pages/cart/checkout.jsp?orderId=" + orderId);
    }

    /**
     * 查询某一用户的所有订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        //如果购物车或用户信息为空，重定向回主页
        if (user == null) {
            response.sendRedirect(BASE_PATH);
        }
        //获取订单信息
        List<Order> orderList = orderService.myOrders(user.getId());
        //将订单信息放到request域中
        request.setAttribute("orderList", orderList);
        //请求转发到订单页面
        request.getRequestDispatcher("pages/order/order.jsp").forward(request, response);
    }

    /**
     * 查询某一订单的明细，即查询某一订单的所有订单项
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        //如果购物车或用户信息为空，重定向回主页
        if (user == null) {
            response.sendRedirect(BASE_PATH);
        }
        //查询订单明细
        List<OrderItem> orderItemList = orderService.orderDetails(request.getParameter("orderId"));
        //将订单明细放入request域中
        request.setAttribute("orderItemList", orderItemList);
        //请求转发到订单详情页面
        request.getRequestDispatcher("pages/order/order_details.jsp").forward(request, response);

    }

    /**
     * 查询所有订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void allOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断用户有没有管理员权限
        Boolean isManager = (Boolean) request.getSession().getAttribute("isManager");
        //如果不是管理员，重定向回首页
        if (isManager == null || !isManager) {
            response.sendRedirect(BASE_PATH);
            return;
        }
        //获取所有订单
        List<Order> orderList = orderService.allOrders();
        //将订单放入request域中
        request.setAttribute("orderList", orderList);
        //请求转发到订单管理界面
        request.getRequestDispatcher("pages/manager/order_manager.jsp").forward(request, response);
    }

    /**
     * 发货
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //更改订单状态
        orderService.sendOrder(request.getParameter("orderId"));
        //重定向回订单管理界面
        response.sendRedirect(BASE_PATH + "orderServlet?action=allOrders");
    }

    /**
     * 收获
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.receiveOrder(orderId);
        response.sendRedirect(BASE_PATH + "orderServlet?action=myOrders");
    }
}
