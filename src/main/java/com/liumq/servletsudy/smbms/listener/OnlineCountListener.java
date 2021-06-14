package com.liumq.servletsudy.smbms.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计网站在线人数
 * 统计session
 */
public class OnlineCountListener implements HttpSessionListener {

    /**
     * 创建session的监听：看你的一举一动
     * 一旦创建session 就会出发这个方法
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();

            onlineCount = new Integer(count+1);
        }
        ctx.setAttribute("onlineCount", onlineCount);
    }

    /**
     * 销毁session的监听
     * 一旦销毁session 就会出发这个方法
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();

            onlineCount = new Integer(count--);
        }
        ctx.setAttribute("onlineCount", onlineCount);
    }
}
