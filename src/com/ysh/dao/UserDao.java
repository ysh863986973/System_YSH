package com.ysh.dao;


import com.ysh.pojo.*;

import java.util.List;

/**
 * User数据库操作DAO层接口
 *
 * @author Anonymous
 * @date 2019-10-09 11:04
 */
public interface UserDao {
    /**
     * 登陆验证方法，返回值是User类对象
     * @param user 传入一个User类对象，根据用户指定的数据创建
     * @return User类对象，如果存在返回User对象，不存在返回null
     */
    User login(User user);

    /**
     * 增加注册账号密码的方法，返回值是增加了几个
     * @param user 传入一个User类对象，根据用户指定的数据创建
     * @return      增加了几个，如果注册失败返回0
     */
    int addSignIn(User user);
    
    /**
     * 解雇员工的方法，返回值是删除了几行（1删除成功，0删除失败）
     * @param userId 传入一个指定的userId， 根据指定的Id删除指定的员工的信息  （解雇）
     * @return 解雇了1个员工，没有找到指定员工则解雇失败返回0.
     */
    int deleteUser(int userId);

    /**
     * 修改员工信息的方法，返回值是修改了几行
     * @param user  传入worker类对象，根据管理员要修改的信息进行修改
     * @return  返回值修改了几行 修改失败返回0
     */
    int modifyUser(User user);

    /**
     * 寻找指定Id下员工信息的方法，返回值是User类员工的信息数据
     * @param userId 传入一个指定的workerId，根据指定的Id寻找该Id下员工的信息
     * @return 返回worker类对象
     */
    List<User> findById(int userId);

    List<User> findByGenderDao(int gender);

    List<User> findByNameDao(String name);

    List<User> findByIDNumberDao(String IDNumber);

    /**
     * 寻找所有员工信息的方法，返回值是list集合
     * @return  返回list集合，展示所有员工的信息
     */
    List<User> findAll();

    // 条件过滤

    List<User> filterDao(String filter, int begin, int end);

//    List<User> filterAgeDao(int beginAge, int endAge);
//    List<Salary> filterSalaryDao(int beginSalary, int endSalary);

//    /**
//     * 模糊查询名字的方法 返回值是User类员工的信息数据
//     * @param userName  传入一个或几个文字，查询所有与这几个文字相关的员工名字的信息
//     * @return  返回值是User类对象
//     */
//    List<User> findLike (String userName);


    /**
     *培训模块  寻找所有的培训课程
     * @return  返回值是TrainingCourse类对象
     */
    int addTrainDao(Train train);
    int modifyGradeTrainDao(int grade, int studentId);
    List<Train> findByIdTrainDao(int trainId);
    List<TrainingCourse> findAllTrainCourse();
    List<Train> findAllTrain();
    List<Train> findByCourseDao(String course);
    int modifyTwoTrainIsTrainingDao(int trainId);
    int modifyTwoTrainingCourseIsTrainingDao(int trainId);
    int modifyOneTrainIsTrainingDao(int trainId);
    int modifyOneTrainingCourseIsTrainingDao(int trainId);
    List<TrainingCourse> findByIdTrainCourseDao(int trainingCourseId);
    int addTrainingCourseDao(TrainingCourse trainingCourse);
    int deleteTrainingCourseDao(int trainingCourseId);

    // 工资模块

    int addSalaryDao(Salary salary);
    List<Salary> findAllSalaryDao();
    int deleteSalaryDao(int salaryId);
    int modifySalaryDao(Salary salary);
    List<Salary> findByIdSalaryDao(int salaryId);




    // 简历

    int addApplicantDao(Applicant applicant);
    int deleteApplicantDao(int addApplicantId);
    int deleteApplicantIsHiringDao();

    int modifyApplicantIsHiringDao(int applicantId);
    List<Applicant> findAllApplicant();
    List<Applicant> findByIdApplicantDao(int applicantId);
    List<Applicant> findThePassDao();
}
