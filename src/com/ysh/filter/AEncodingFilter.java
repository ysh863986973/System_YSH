package com.ysh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 请求和响应编码集处理过滤器
 *
 * @author Anonymous
 * @date 2019-10-09 10:58
 */
@WebFilter("/*")
public class AEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获取用户访问的资源名称
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();

        HttpSession session = req.getSession(false);

        // 这些资源是登录相关的资源，不应该被过滤，可以允许用户之间访问
        if (requestURI.contains("login.jsp") || requestURI.contains("login") || requestURI.contains(".jpg") || requestURI.contains(".html")) {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            filterChain.doFilter(req, resp);
        } else

            if (null == session || session.getAttribute("userName") == null) {
            // 没有session信息。
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
