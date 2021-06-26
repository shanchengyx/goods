package com.gyx.web;

import com.google.gson.Gson;
import com.gyx.pojo.User;
import com.gyx.service.UserService;
import com.gyx.service.impl.UserServiceImpl;
import com.gyx.utils.WebUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 处理用户信息的Servlet
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 检测用户名是否存在
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void existUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean isExistUsername = userService.existUsername(username);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("isExistUsername", isExistUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);
    }

    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //获取验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //获取后要从session中删除，避免重复注册
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
        //先判断验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            //再判断用户名是否存在
            if (userService.existUsername(username)) {
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                System.out.println("用户名[" + username + "]已存在，注册失败");
                request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
            } else {//不存在就可以注册
                userService.register(user);
                System.out.println("[" + username + "]注册成功");
                response.sendRedirect(BASE_PATH + "pages/user/register_success.jsp");
            }
        } else {
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            System.out.println("验证码[" + code + "]错误，注册失败");
            request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
        }
    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
        user = userService.login(user);//登录
        //如果登录返回的user非空，就登录成功，反之登录失败
        if (user != null) {
            System.out.println("[" + username + "]登录成功");
            //将用户信息放入session
            request.getSession().setAttribute("user", user);
            //查询用户是否有管理员权限
            boolean isManager = userService.isManager(user.getId());
            //将isManager放入session
            request.getSession().setAttribute("isManager", isManager);
            response.sendRedirect(BASE_PATH);
        } else {
            System.out.println("[" + username + "]登录失败");
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
        }
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("[" + user.getUsername() + "]退出登录");
        //使session失效，即可达成退出登录的效果
        request.getSession().invalidate();
        response.sendRedirect(BASE_PATH);
    }
}
