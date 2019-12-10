package com.ysh.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
http://localhost:8080/Day34_SL/action?method=select
http://localhost:8080/Day34_SL/action?method=add
http://localhost:8080/Day34_SL/action?method=update
http://localhost:8080/Day34_SL/action?method=delete


1. 要求程序中的所有Servlet程序都要继承BaseServlet
2. 但是不需要完成对应的doGet,doPost方法来对应Http协议请求和响应
3. BaseServlet子类Servlet程序需要有一个标记！！！@WebServlet
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取URL请求参数中核心参数method对应的值，也就是当前URL请求执行的方法
        String methodName = req.getParameter("method");

        /*
         2. 获取Class类对象
         this表示的是当前BaseServlet对应的子类对象
         */
        Class<? extends BaseServlet> aClass = this.getClass();

        /*
        3. 根据反射，通过Class类对象，以及对应methodName获取对应的方法，执行
         */
        try {
            aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
