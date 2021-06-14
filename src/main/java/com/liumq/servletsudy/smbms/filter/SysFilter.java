package com.liumq.servletsudy.smbms.filter;

import com.liumq.servletsudy.smbms.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录不能访问成功页面的过滤器
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //先将req resp 强制转换成子类
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //在过滤器层面考察当前session中是否有user,没有 说明没有登录，直接重定向到error页面
        Object userSession = req.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null) {
            System.out.println("过滤器【拦截】了未登录的用户权限页面");
            resp.sendRedirect("../error.jsp");
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
