package com.gyx.filter;

import com.gyx.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.gyx.web.BaseServlet.BASE_PATH;


/**
 * 过滤管理权限才能访问的目录
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        Boolean isManager = (Boolean) httpServletRequest.getSession().getAttribute("isManager");
        if (user == null || isManager == null || !isManager) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect(BASE_PATH);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
