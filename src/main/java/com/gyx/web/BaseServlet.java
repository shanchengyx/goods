package com.gyx.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 基本的Servlet
 */
public abstract class BaseServlet extends HttpServlet {
    public final static String BASE_PATH = "http://localhost:8080/goods/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //设置请求编码，避免乱码
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            //根据请求参数获取相应的方法
            String action = request.getParameter("action");
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
