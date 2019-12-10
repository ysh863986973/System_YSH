package com.ysh.servlet;

import com.ysh.dao.impl.UserDaoImpl;
import com.ysh.pojo.*;
import com.ysh.service.UserService;
import com.ysh.service.impl.UserServiceImpl;
import com.ysh.utils.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * User数据库操作Servlet层
 *
 * @author Anonymous
 * @date 2019-10-09 14:04
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    /**
     * 解雇指定Id的员工
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws IOException IO异常
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        userService.removeByIdService(Integer.parseInt(id));
        resp.sendRedirect("user?method=list");
    }

    /**
     * 修改指定Id员工的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");

        List<User> byIdService = userService.findByIdService(Integer.parseInt(id));

        req.setAttribute("user", byIdService);
        req.getRequestDispatcher("modify.jsp").forward(req, resp);
    }

    /**
     * 获取从前端传入的信息的方法
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws IOException IO异常
     * @throws InvocationTargetException 目标异常
     * @throws IllegalAccessException 非法访问异常
     */
    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();

        BeanUtils.populate(user, parameterMap);
        new UserDaoImpl().modifyUser(user);
        resp.sendRedirect("user?method=list");
    }

    /**
     * 根据指定Id展示该Id的所有信息
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<User> byIdService = userService.findByIdService(Integer.parseInt(id));

        req.setAttribute("all", byIdService);
        req.getRequestDispatcher("listJsp.jsp").forward(req, resp);
    }

    /**
     * 查看所有员工的信息
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        HttpSession session = req.getSession(false);
//        User userName = (User) session.getAttribute("userName");
//        int roleId = userName.getRoleId();
//
//        if (roleId == 1) {
//        }

            List<User> list = userService.listService();

            req.setAttribute("all", list);
            req.getRequestDispatcher("listJsp.jsp").forward(req, resp);

    }



    // 条件过滤


    /**
     * 过滤查询的方法，可根据指定名字的字段模糊，性别，年龄，基本工资进行查询
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void filterData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filter = req.getParameter("filter");
        String begin = req.getParameter("begin");
        String end = req.getParameter("end");
        if (filter.equals("age") || filter.equals("basicSalary")) {
            if ("" == begin) {
                begin = "0";
            }
            if ("" == end) {
                end = "1000000";
            }
            List<User> list = userService.filterService(filter, Integer.parseInt(begin), Integer.parseInt(end));
            req.setAttribute("all", list);
        } else if (filter.equals("gender")) {
            if (begin.equals("男")) {
                List<User> byGenderService0 = userService.findByGenderService(0);
                req.setAttribute("all", byGenderService0);
            } else if (begin.equals("女")) {
                List<User> byGenderService1 = userService.findByGenderService(1);
                req.setAttribute("all", byGenderService1);
            } else {
                resp.sendRedirect("null.jsp");
            }
        } else if (filter.equals("name")) {
            List<User> byNameDao = userService.findByNameService(begin);
            req.setAttribute("all", byNameDao);
        }

        req.getRequestDispatcher("filterData.jsp").forward(req, resp);
    }

    /**
     * 在过滤界面展示所有员工的方法
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void filterAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.listService();

        req.setAttribute("all", list);
        req.getRequestDispatcher("filterData.jsp").forward(req, resp);
    }






    /* 员工权限 */


    /**
     * 员工寻找自己信息的方法
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void findOneself(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<User> byIdService = userService.findByIdService(Integer.parseInt(id));


        req.setAttribute("all", byIdService);
        req.getRequestDispatcher("listJsp.jsp").forward(req, resp);
    }

    /**
     * 修改自己账号密码的方法
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void modifyOneself(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<User> byIdService = userService.findByIdService(Integer.parseInt(id));


        req.setAttribute("oneself", byIdService);
        req.getRequestDispatcher("modifyOneself.jsp").forward(req, resp);
    }

    /**
     * 根据前端传入的修改后的账号密码数据，修改数据库账号密码的方法
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws InvocationTargetException 目标异常
     * @throws IllegalAccessException 非法访问异常
     * @throws IOException IO异常
     */
    public void updateOneself(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();

        BeanUtils.populate(user, parameterMap);
        new UserDaoImpl().modifyUser(user);
        resp.sendRedirect("modifyOK.jsp");
    }




    // 简历模块

    /**
     * 删除简历的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void deleteApplicant(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");

        boolean b = userService.deleteApplicantService(Integer.parseInt(id));

        req.getRequestDispatcher("user?method=allApplicant").forward(req, resp);
    }

    /**
     * 修改简历中的isHiring属性，修改为1表示简历通过，为0表示简历不通过，并删除不通过的简历
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void modifyApplicant(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String[] isHiring = parameterMap.get("isHiring");

        for (String s : isHiring) {
            userService.modifyApplicantIsHiringService(Integer.parseInt(s));
        }
        int i = userService.deleteApplicantIsHiringService();
        req.getRequestDispatcher("user?method=thePass").forward(req, resp);
    }

    /**
     * 展示所有简历的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void allApplicant(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Applicant> applicants = userService.allApplicantService();

        req.setAttribute("applicants", applicants);
        req.getRequestDispatcher("allApplicant.jsp").forward(req, resp);
    }

    /**
     * 如果面试失败，将该简历从简历数据库中删除的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void deleteThePass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        boolean b = userService.deleteApplicantService(Integer.parseInt(id));

        req.getRequestDispatcher("user?method=thePass").forward(req, resp);
    }

    /**
     * 展示所有简历通过的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void thePass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Applicant> thePassService = userService.findThePassService();

        req.setAttribute("applicants", thePassService);
        req.getRequestDispatcher("allThePass.jsp").forward(req, resp);
    }

    /**
     * 修改简历中面试通过的信息，准备入职，将修改后的信息添加到user数据库中
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void modifyThePass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        List<Applicant> byIdApplicantService = userService.findByIdApplicantService(Integer.parseInt(id));
        boolean b = userService.deleteApplicantService(Integer.parseInt(id));
        req.setAttribute("modifyThePass", byIdApplicantService);
        req.getRequestDispatcher("modifyThePass.jsp").forward(req, resp);
    }

    /**
     * 和上面方法一起使用
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws InvocationTargetException 目标异常
     * @throws IllegalAccessException 非法访问异常
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void updateThePass(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        User user = new User();

        BeanUtils.populate(user, parameterMap);

        boolean b = userService.addSignInService(user);

        String[] IDNumbers = parameterMap.get("IDNumber");

        for (String s : IDNumbers) {
            List<User> byIDNumberService = userService.findByIDNumberService(s);
            req.setAttribute("byIDNumberService", byIDNumberService);
        }
        // 跳转展示自己的所有信息，后面加两个增加工资和培训的按钮

        req.getRequestDispatcher("addSalaryAndTrain.jsp").forward(req, resp);
    }

    /**
     * 退出账号的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws IOException IO异常
     */
    public void exit (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);

        if (null != session) {
            session.invalidate();
            Cookie jsessionid = new Cookie("JSESSIONID", "");
            jsessionid.setMaxAge(0);
            resp.addCookie(jsessionid);
        }

        resp.sendRedirect("login.jsp");
    }
}
