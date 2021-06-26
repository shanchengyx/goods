package com.gyx.web;

import com.google.gson.Gson;
import com.gyx.pojo.Cart;
import com.gyx.pojo.CartItem;
import com.gyx.pojo.Goods;
import com.gyx.service.GoodsService;
import com.gyx.service.impl.GoodsServiceImpl;
import com.gyx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 用于处理购物车请求的Servlet
 */
public class CartServlet extends BaseServlet {
    private GoodsService service = new GoodsServiceImpl();

    /**
     * 添加商品项
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品的id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //通过service获取商品信息
        Goods goods = service.queryGoodsById(id);
        //将商品信息转换成item
        CartItem item = new CartItem(id, goods.getName(), 1, goods.getPrice(), goods.getPrice().multiply(new BigDecimal(1)));
        //将item存到session中，以便在主页上显示最新加入购物车的商品信息
        request.getSession().setAttribute("latestItem", item);
        //先从session中获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //如果cart为空，就创建一个cart，并放入session
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //将item加入到购物车中
        cart.addItem(item);
        //返回购物车的总商品数和最后加入的商品名称
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", item.getName());
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);
    }

    /**
     * 删除商品项
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的商品id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //购物车不为空，才能删除
        if (cart != null) {
            //从购物车中删除商品
            cart.deleteItem(id);
            //重定向回购物车
            response.sendRedirect(BASE_PATH + "pages/cart/cart.jsp");
        }
    }

    /**
     * 更新商品项
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先获取商品id，要修改成多少数量
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 0);
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //购物车为空的话，就新建一个
        if (cart == null) {
            cart = new Cart();
        }
        //修改商品数量
        cart.updateCount(id, count);
        //重定向回购物车
        response.sendRedirect(BASE_PATH + "pages/cart/cart.jsp");
    }

    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //购物车不为空，才能清空
        if (cart != null) {
            //清空购物车
            cart.clear();
            //重定向回购物车
            response.sendRedirect(BASE_PATH + "pages/cart/cart.jsp");
        }
    }
}
