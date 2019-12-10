package com.ysh.service;


import com.ysh.pojo.*;

import java.util.List;

/**
 * User数据库操作service层接口
 *
 * @author Anonymous
 * @date 2019-10-09 11:44
 */
public interface UserService {


    User userLoginService(User user);

    boolean addSignInService(User user);

    boolean removeByIdService(int userId);

    int modifyUserService(User user);

    List<User> findByIdService(int userId);

    List<User> findByGenderService(int gender);

    List<User> findByNameService(String name);

    List<User> findByIDNumberService(String IDNumber);

    List<User> listService();

    //条件过滤

    List<User> filterService(String filter, int begin, int end);

//    List<User> filterAgeService(int beginAge, int endAge);
//    List<Salary> filterSalaryService(int beginSalary, int endSalary);

//    void modifyByIdService(int workerId);

    int addTrainService(Train train);
    int modifyGradeTrainService(int grade, int studentId);
    List<Train> findByIdTrainService(int trainId);
    List<Train> findByCourseService(String course);
    List<TrainingCourse> allTrainingCourseService();

    List<Train> allTrainService();
    int modifyTwoTrainIsTrainingService(int trainId);
    int modifyOneTrainIsTrainingService(int trainId);
    int modifyOneTrainingCourseIsTrainingService(int trainId);
    int modifyTwoTrainingCourseIsTrainingService(int trainId);
    List<TrainingCourse> findByIdTrainCourseService(int trainingCourseId);
    int addTrainingCourseService(TrainingCourse trainingCourse);
    int deleteTrainingCourseService(int trainingCourseId);




    // 工资模块

    int addSalaryService(Salary salary);
    List<Salary> allSalaryService();
    boolean deleteSalaryService(int salaryId);
    int modifySalaryService(Salary salary);
    List<Salary> findByIdSalaryService(int salaryId);








    //简历

    boolean addApplicantService(Applicant applicant);

    boolean deleteApplicantService(int applicantId);

    int deleteApplicantIsHiringService();

    int modifyApplicantIsHiringService(int applicantId);

    List<Applicant> allApplicantService();
    List<Applicant> findByIdApplicantService(int applicantId);

    List<Applicant> findThePassService();

}
