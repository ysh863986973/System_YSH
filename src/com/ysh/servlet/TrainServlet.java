package com.ysh.servlet;

import com.ysh.pojo.Train;
import com.ysh.pojo.TrainingCourse;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@WebServlet("/train")
public class TrainServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 公司增加培训的课程的方法，可供员工挑选
     *
     * @param req
     * @param resp
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void addTrainingCourse(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        TrainingCourse trainingCourse = new TrainingCourse();

        BeanUtils.populate(trainingCourse, parameterMap);

        userService.addTrainingCourseService(trainingCourse);

        resp.sendRedirect("train?method=allTrainingCourse");
    }

    /**
     * 删除课程的方法   （万一添加课程失误，可用删除方法删除指定的课程，一般用不到）
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public void deleteTrainingCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int i = userService.deleteTrainingCourseService(Integer.parseInt(id));

        resp.sendRedirect("train?method=allTrainingCourse");
    }

    /**
     * 查看所有的课程 （并自动删除所有已经培训结束的课程，防止员工乱报名）
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void allTrainingCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<TrainingCourse> trainingCourses = userService.allTrainingCourseService();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for (TrainingCourse trainingCours : trainingCourses) {
            int id = trainingCours.getId();

            String beginTime1 = trainingCours.getBeginTime();
            Timestamp beginTime = Timestamp.valueOf(beginTime1);

            String endTime1 = trainingCours.getEndTime();
            Timestamp endTime = Timestamp.valueOf(endTime1);
            // 把培训开始时间小于当前时间并且小于结束时间的状态改为正在培训
            // beginTime < 目前时间 < endTime
            if (beginTime.before(timestamp) && timestamp.before(endTime)) {
                userService.modifyOneTrainingCourseIsTrainingService(id);
            } else
                // 把培训当前时间大于结束时间的状态改为培训完成
                // 目前时间 > 结束时间
                if (endTime.before(timestamp)) {
                    userService.modifyTwoTrainingCourseIsTrainingService(id);
                }
        }
        List<TrainingCourse> trainingCourses1 = userService.allTrainingCourseService();
        req.setAttribute("trains", trainingCourses1);
        req.getRequestDispatcher("allTrainCourse.jsp").forward(req, resp);
    }

    public void findByCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course = req.getParameter("course");

        List<Train> trains = userService.findByCourseService(course);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for (Train train : trains) {
            int iid = train.getId();

            String beginTime1 = train.getBeginTime();
            Timestamp beginTime = Timestamp.valueOf(beginTime1);

            String endTime1 = train.getEndTime();
            Timestamp endTime = Timestamp.valueOf(endTime1);
            // 把培训开始时间小于当前时间并且小于结束时间的状态改为正在培训
            // beginTime < 目前时间 < endTime
            if (beginTime.before(timestamp) && timestamp.before(endTime)) {
                userService.modifyOneTrainIsTrainingService(iid);
            } else
                // 把培训当前时间大于结束时间的状态改为培训完成
                // 目前时间 > 结束时间
                if (endTime.before(timestamp)) {
                    userService.modifyTwoTrainIsTrainingService(iid);
                }
        }

        List<Train> byCourseService = userService.findByCourseService(course);
        req.setAttribute("trains", byCourseService);
        req.getRequestDispatcher("allTrain.jsp").forward(req, resp);
    }


    // 2. 员工的培训情况


    /**
     * 获取培训课程里的课程、开始、结束时间和讲师的信息的方法，并转给增加界面addTrain.jsp中
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getTrain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<TrainingCourse> trainCourse = userService.findByIdTrainCourseService(Integer.parseInt(id));

        req.setAttribute("trainCourse", trainCourse);
        req.getRequestDispatcher("addTrain.jsp").forward(req, resp);
    }

    public void getTrainStudentId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");

        List<Train> byIdTrainService = userService.findByIdTrainService(Integer.parseInt(studentId));

        req.setAttribute("trains", byIdTrainService);
        req.getRequestDispatcher("grade.jsp").forward(req, resp);
    }

    public void gradeTrain(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] grades = parameterMap.get("grade");
        String[] studentIds = parameterMap.get("id");
        for (int i = 0; i < studentIds.length; i++) {

            int student = 0;
            int grade = 0;
            String studentId = studentIds[i];
            student = Integer.parseInt(studentId);
            String grade1 = grades[i];
            grade = Integer.parseInt(grade1);

            userService.modifyGradeTrainService(grade, student);
        }
        resp.sendRedirect("null.jsp");
    }

    /**
     * 增加培训信息的方法
     *
     * @param req
     * @param resp
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void addTrain(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        Train train = new Train();
        BeanUtils.populate(train, parameterMap);

        int i = userService.addTrainService(train);

        resp.sendRedirect("addApplicantOK.jsp");
    }

    /**
     * 根据指定Id寻找该员工的培训状态 （培训状态可根据目前系统时间来判定培训的状态）
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findByIdTrain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        List<Train> trains = userService.findByIdTrainService(Integer.parseInt(id));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for (Train train : trains) {
            int iid = train.getId();

            String beginTime1 = train.getBeginTime();
            Timestamp beginTime = Timestamp.valueOf(beginTime1);

            String endTime1 = train.getEndTime();
            Timestamp endTime = Timestamp.valueOf(endTime1);
            // 把培训开始时间小于当前时间并且小于结束时间的状态改为正在培训
            // beginTime < 目前时间 < endTime
            if (beginTime.before(timestamp) && timestamp.before(endTime)) {
                userService.modifyOneTrainIsTrainingService(iid);
            } else
                // 把培训当前时间大于结束时间的状态改为培训完成
                // 目前时间 > 结束时间
                if (endTime.before(timestamp)) {
                    userService.modifyTwoTrainIsTrainingService(iid);
                }
        }

        List<Train> trains1 = userService.findByIdTrainService(Integer.parseInt(id));
        req.setAttribute("trains", trains1);
        req.getRequestDispatcher("findByIdTrain.jsp").forward(req, resp);
    }

    /**
     * 展示所有员工的培训信息，并根据现在的时间判断员工的培训状态 （培训信息）
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    public void allTrain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Train> trains = userService.allTrainService();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for (Train train : trains) {
            int id = train.getId();

            String beginTime1 = train.getBeginTime();
            Timestamp beginTime = Timestamp.valueOf(beginTime1);

            String endTime1 = train.getEndTime();
            Timestamp endTime = Timestamp.valueOf(endTime1);
            // 把培训开始时间小于当前时间并且小于结束时间的状态改为正在培训
            // beginTime < 目前时间 < endTime
            if (beginTime.before(timestamp) && timestamp.before(endTime)) {
                userService.modifyOneTrainIsTrainingService(id);
            } else
                // 把培训当前时间大于结束时间的状态改为培训完成
                // 目前时间 > 结束时间
                if (endTime.before(timestamp)) {
                    userService.modifyTwoTrainIsTrainingService(id);
                }
        }
        List<Train> trains1 = userService.allTrainService();
        req.setAttribute("trains", trains1);

        req.getRequestDispatcher("allTrain.jsp").forward(req, resp);
    }
}
