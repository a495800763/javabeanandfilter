package com.liumq.servletsudy.smbms.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 实现请求转码的过滤器
 */
public class CharacterEncodingFilter implements Filter {

    /**
     * 初始化：web服务器启动时，已经在web.xml 中配置的过滤器就会初始化,随时等待需要过滤的请求
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter 初始化");
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException 1 doFilter 中的所有代码，在过滤指定请求时都会执行
     *                          2 指定请求的配置在web.xml 中
     *                          3 必须要让过滤器继续执行 filterChain.doFilter(servletRequest,servletResponse);
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        servletRequest.setCharacterEncoding("utf-8");

        System.out.println("CharacterEncodingFilter 执行前");
        //让请求继续执行，如果不写，请求将被拦截停止
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("CharacterEncodingFilter 执行后");
    }

    /**
     * 销毁：web服务器关闭时才会销毁
     */
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter 销毁了");
    }
}
