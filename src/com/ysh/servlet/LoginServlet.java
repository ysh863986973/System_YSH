package com.ysh.servlet;

import com.ysh.pojo.Applicant;
import com.ysh.pojo.User;
import com.ysh.service.UserService;
import com.ysh.service.impl.UserServiceImpl;
import com.ysh.utils.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 用户登陆方法，判断是否登陆成功
     *
     * @param request 请求类对象
     * @param response 响应类对象
     * @throws InvocationTargetException 目标异常
     * @throws IllegalAccessException 非法访问异常
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();

        BeanUtils.populate(user, parameterMap);

        user = userService.userLoginService(user);

        if (null == user) {
            // 登陆失败
            request.setAttribute("msg", "用户名或者密码错误");

            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession(false);
            session.setAttribute("userName", user);

            request.getRequestDispatcher("1-main.jsp").forward(request, response);
        }
    }

    /**
     * 投简历的方法，直接到简历数据库中
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws InvocationTargetException 目标异常
     * @throws IllegalAccessException 非法访问异常
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void addApplicant(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        Applicant applicant = new Applicant();

        BeanUtils.populate(applicant, parameterMap);

        boolean b = userService.addApplicantService(applicant);

        req.getRequestDispatcher("addApplicantOK.jsp").forward(req, resp);
//        resp.sendRedirect("addApplicantOK.jsp");
    }
}
