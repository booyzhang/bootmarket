package com.booy.boot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.html")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        //获取用户当前路径
        String path = request.getServletPath();
        //不拦截的页面
        if("/login.html".equals(path) || "/doLogin.html".equals(path)){
            filterChain.doFilter(request,response);
            return;
        }
        //没有登录，进行拦截
        if(request.getSession().getAttribute("session_user")==null){
            response.sendRedirect("login.html");
            return;
        }
        //已经登录
        filterChain.doFilter(request,response);
    }
}
