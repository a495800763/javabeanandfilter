package com.liumq.servletsudy.smbms.servlet;

import com.liumq.servletsudy.smbms.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object userSession = req.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession != null) {
            req.getSession().removeAttribute(Constant.USER_SESSION);
            resp.sendRedirect("../login.jsp");
        } else {
            resp.sendRedirect("../login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
