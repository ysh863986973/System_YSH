package com.ysh.service.impl;

import com.ysh.dao.UserDao;
import com.ysh.dao.impl.UserDaoImpl;
import com.ysh.pojo.*;
import com.ysh.service.UserService;

import java.util.List;

/**
 * User数据库操作Service层实现类
 *
 * @author Anonymous
 * @date 2019-10-09 11:44
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User userLoginService(User user) {
        return userDao.login(user);
    }

    @Override
    public boolean addSignInService(User user) {
        return userDao.addSignIn(user) > 0;
    }


    /**
     * 根据指定的ID，删除对应的员工
     *
     * @param userId 指定的ID号
     * @return 删除成功返回true，失败返回false
     */
    @Override
    public boolean removeByIdService(int userId) {

        return userDao.deleteUser(userId) > 0;
    }

    /**
     * 找出对应ID的员工信息
     *
     * @param userId 指定的员工ID号
     * @return 找到对应的员工返回员工类对象，没有找到返回null
     */
    @Override
    public List<User> findByIdService(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public List<User> findByGenderService(int gender) {
        return userDao.findByGenderDao(gender);
    }

    @Override
    public List<User> findByNameService(String name) {
        return userDao.findByNameDao(name);
    }

    @Override
    public List<User> findByIDNumberService(String IDNumber) {
        return userDao.findByIDNumberDao(IDNumber);
    }

    @Override
    public List<User> listService() {
        return userDao.findAll();
    }

    // 条件过滤

    @Override
    public List<User> filterService(String filter, int begin, int end) {
        return userDao.filterDao(filter, begin, end);
    }


//    @Override
//    public List<User> filterAgeService(int beginAge, int endAge) {
//        return userDao.filterAgeDao(beginAge, endAge);
//    }
//
//    @Override
//    public List<Salary> filterSalaryService(int beginSalary, int endSalary) {
//        return userDao.filterSalaryDao(beginSalary, endSalary);
//    }

//    /**
//     * 根据指定Id修改指定Worker的信息     （没用到,后期修改）
//     *
//     * @param userId 指定的员工ID号
//     */

    // 培训
    @Override
    public int addTrainService(Train train) {
        return userDao.addTrainDao(train);
    }

    @Override
    public int modifyGradeTrainService(int grade, int studentId) {
        return userDao.modifyGradeTrainDao(grade, studentId);
    }

    @Override
    public List<Train> findByIdTrainService(int trainId) {
        return userDao.findByIdTrainDao(trainId);
    }

    @Override
    public List<Train> findByCourseService(String course) {
        return userDao.findByCourseDao(course);
    }

    @Override
    public int modifyUserService(User user) {
        return userDao.modifyUser(user);
    }

    @Override
    public List<TrainingCourse> allTrainingCourseService() {return userDao.findAllTrainCourse();}

    @Override
    public List<Train> allTrainService() {return userDao.findAllTrain();}

    @Override
    public int modifyTwoTrainIsTrainingService(int trainId) {
        return userDao.modifyTwoTrainIsTrainingDao(trainId);
    }

    @Override
    public int modifyTwoTrainingCourseIsTrainingService(int trainId) {
        return userDao.modifyTwoTrainingCourseIsTrainingDao(trainId);
    }
    @Override
    public int modifyOneTrainIsTrainingService(int trainId) {
        return userDao.modifyOneTrainIsTrainingDao(trainId);
    }

    @Override
    public int modifyOneTrainingCourseIsTrainingService(int trainId) {
        return userDao.modifyOneTrainingCourseIsTrainingDao(trainId);
    }
    @Override
    public List<TrainingCourse> findByIdTrainCourseService(int trainingCourseId) {
        return userDao.findByIdTrainCourseDao(trainingCourseId);
    }
    @Override
    public int addTrainingCourseService(TrainingCourse trainingCourse) {
        return userDao.addTrainingCourseDao(trainingCourse);
    }
    @Override
    public int deleteTrainingCourseService(int trainingCourseId) {
        return userDao.deleteTrainingCourseDao(trainingCourseId);
    }



    // 工资模块

    @Override
    public int addSalaryService(Salary salary) {
        return userDao.addSalaryDao(salary);
    }
    @Override
    public boolean deleteSalaryService(int salaryId) {
        return userDao.deleteSalaryDao(salaryId) > 0 ;
    }
    @Override
    public int modifySalaryService(Salary salary) {
        return userDao.modifySalaryDao(salary);
    }
    @Override
    public List<Salary> findByIdSalaryService(int salaryId) {
        return userDao.findByIdSalaryDao(salaryId);
    }
    @Override
    public List<Salary> allSalaryService() {
        return userDao.findAllSalaryDao();
    }







    @Override
    public boolean addApplicantService(Applicant applicant) {
        return userDao.addApplicantDao(applicant) > 0;
    }

    @Override
    public boolean deleteApplicantService(int applicantId) {
        return userDao.deleteApplicantDao(applicantId) > 0;
    }

    @Override
    public int deleteApplicantIsHiringService() {
        return userDao.deleteApplicantIsHiringDao();
    }


    @Override
    public int modifyApplicantIsHiringService(int applicantId) {
        return userDao.modifyApplicantIsHiringDao(applicantId);
    }

    @Override
    public List<Applicant> allApplicantService() {
        return userDao.findAllApplicant();
    }

    @Override
    public List<Applicant> findByIdApplicantService(int applicantId) {
        return userDao.findByIdApplicantDao(applicantId);
    }

    @Override
    public List<Applicant> findThePassService() {
        return userDao.findThePassDao();
    }
}
