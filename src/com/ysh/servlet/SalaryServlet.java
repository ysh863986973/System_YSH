package com.ysh.servlet;

import com.ysh.dao.impl.UserDaoImpl;
import com.ysh.pojo.Salary;
import com.ysh.service.UserService;
import com.ysh.service.impl.UserServiceImpl;
import com.ysh.utils.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/salary")
public class SalaryServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 增加员工工资的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws InvocationTargetException 目标异常
     * @throws IllegalAccessException 非法访问异常
     * @throws IOException IO异常
     */
    public void addSalary(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        Salary salary = new Salary();

        BeanUtils.populate(salary, parameterMap);

        userService.addSalaryService(salary);

        resp.sendRedirect("SignInOK.jsp");
    }

    /**
     * 根据指定Id获取前端传过来的id，name，basicSalary
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void addSalaryId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String basicSalary = req.getParameter("basicSalary");

        req.setAttribute("id", id);
        req.setAttribute("name", name);
        req.setAttribute("basicSalary", basicSalary);
        req.getRequestDispatcher("addSalary.jsp").forward(req, resp);
    }

    /**
     * 删除工资的方法 （只在添加工资错误时使用）
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void deleteSalary(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        boolean b = userService.deleteSalaryService(Integer.parseInt(id));
        req.getRequestDispatcher("salary?method=allSalary").forward(req, resp);
    }

    /**
     * 根据指定id修改该员工所有信息的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void modifySalary(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Salary> byIdSalary = new UserDaoImpl().findByIdSalaryDao(Integer.parseInt(id));

        req.setAttribute("salary", byIdSalary);
        req.getRequestDispatcher("modifySalary.jsp").forward(req, resp);
    }
    /**
     * 获取从前端传入的所有信息的方法，修改指定信息，完成后跳转到所有工资
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void updateSalary(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        Salary salary = new Salary();

        BeanUtils.populate(salary, parameterMap);

        int i = userService.modifySalaryService(salary);
        resp.sendRedirect("salary?method=allSalary");
    }

    /**
     * 查询所有员工工资的方法
     *
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void allSalary(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Salary> salaries = userService.allSalaryService();

        req.setAttribute("salaries", salaries);
        req.getRequestDispatcher("allSalary.jsp").forward(req, resp);
    }

    /**
     * 查自己的工资
     * @param req 请求类对象
     * @param resp 响应类对象
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void findOneselfSalary(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        List<Salary> byIdSalaryService = userService.findByIdSalaryService(Integer.parseInt(id));

        req.setAttribute("salaries", byIdSalaryService);
        req.getRequestDispatcher("oneselfSalary.jsp").forward(req, resp);
    }
}
