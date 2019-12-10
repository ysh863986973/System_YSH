package com.ysh.dao.impl;

import com.ysh.dao.UserDao;
import com.ysh.pojo.*;
import com.ysh.utils.BaseDao;

import java.util.List;

/**
 * User数据库操作DAO层MySQL数据库操作实现类
 *
 * @author Anonymous
 * @date 2019-10-09 11:05
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User login(User user) {
        String sql = "select * from system_ysh.user where userName = ? and password = ?";
        Object[] parameters = {user.getUserName(), user.getPassword()};

        List<? extends User> query = super.query(sql, parameters, user.getClass());

        return query.size() != 0 ? query.get(0) : null;
    }

    @Override
    public int addSignIn(User user) {
        String sql = "insert into system_ysh.user (userName, password, name, age, gender, IDNumber, basicSalary, department, job, createTime, content, roleId) values (?,?,?,?,?,?,?,?,?,?,?,0);";

        Object[] parameters = {user.getUserName(), user.getPassword(), user.getName(), user.getAge(), user.isGender(), user.getIDNumber(), user.getBasicSalary(), user.getDepartment(), user.getJob(), user.getCreateTime(), user.getContent()};

        return super.update(sql, parameters);
    }

    @Override
    public int deleteUser(int userId) {
        String sql1 = "delete from system_ysh.user where id = " + userId;
        String sql2 = "delete from system_ysh.salary where userId = " + userId;
        String sql3 = "delete from system_ysh.train where studentId = " + userId;

        super.update(sql1, null);
        super.update(sql2, null);
        return super.update(sql3, null);
    }
    @Override
    public int modifyUser(User user) {
        String sql = "update system_ysh.user set userName = ?, password = ?, name = ?, age = ?, gender = ?, IDNumber = ?, basicSalary = ?, department = ?, job = ?, createTime = ?, content = ? where id = ?;";

        // 获取worker里的参数保存到parameters数组里面
        Object[] parameters = {user.getUserName(), user.getPassword(), user.getName(), user.getAge(), user.isGender(), user.getIDNumber(), user.getBasicSalary(), user.getDepartment(), user.getJob(), user.getCreateTime(), user.getContent(), user.getId()};

        return super.update(sql, parameters);
    }

    @Override
    public List<User> findById(int userId) {
        String sql = "select * from system_ysh.user where id = " + userId;

        return super.query(sql, null, User.class);

    }

    @Override
    public List<User> findByGenderDao(int gender) {
        String sql = "select * from system_ysh.user where gender = " + gender;

        return super.query(sql, null, User.class);
    }

    @Override
    public List<User> findByNameDao(String begin) {
        String sql = "select * from system_ysh.user where name like '%"+begin+"%'";

        return super.query(sql, null, User.class);
    }

    @Override
    public List<User> findByIDNumberDao(String IDNumber) {
        String sql = "select * from system_ysh.user where IDNumber = '" + IDNumber +"'";

        return super.query(sql, null, User.class);
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from system_ysh.user;";

        return super.query(sql, null, User.class);
    }

    //条件过滤

    @Override
    public List<User> filterDao(String filter, int begin, int end) {
        String sql = "select * from system_ysh.user where  " + filter + " >= " + begin + " and " + filter + " < " + end;

        return super.query(sql, null, User.class);
    }




/*
    @Override
    public List<User> filterAgeDao(int beginAge, int endAge) {
        String sql = "select * from system_ysh.user where age > ? and age < ?";

        Object[] parameters = {beginAge, endAge};

        return super.query(sql, parameters, User.class);
    }

    @Override
    public List<Salary> filterSalaryDao(int beginSalary, int endSalary) {
        String sql = "select * from system_ysh.salary where totalize > ? and totalize < ?";

        Object[] parameters = {beginSalary, endSalary};

        return super.query(sql, parameters, Salary.class);
    }

 */






//    @Override
//    public List<User> findLike (String s) {
//        String sql = "select * from system_ysh.user where userName like ?;" + s + "%";
//
//        List<User> query = super.query(sql, null, User.class);
//
//        // query里有模糊查询的所有数据
//        return query.size() != 0 ? query : null;
//    }


    // 培训模块

    @Override
    public int addTrainDao(Train train) {
        String sql = "insert into system_ysh.train (studentId, name, course, beginTime, endTime, teacher, goal, effect, isTraining, grade) values (?,?,?,?,?,?,?,?,0,0);";

        Object[] parameters = {train.getStudentId(), train.getName(), train.getCourse(), train.getBeginTime(), train.getEndTime(), train.getTeacher(), train.getGoal(), train.getEffect()};

        return super.update(sql, parameters);
    }

    @Override
    public int modifyGradeTrainDao(int grade, int studentId) {
        String sql = "update system_ysh.train set grade = ? where id = ?";

        Object[] parameters = {grade, studentId};

        return update(sql, parameters);
    }

    @Override
    public List<Train> findByIdTrainDao(int trainId) {
        String sql = "select * from system_ysh.train where studentId = " + trainId;

        return super.query(sql, null, Train.class);
    }

    @Override
    public List<TrainingCourse> findAllTrainCourse() {
        String sql = "select * from system_ysh.training_course;";

        return super.query(sql, null, TrainingCourse.class);
    }

    @Override
    public List<Train> findByCourseDao(String course) {
        String sql = "select * from system_ysh.train where course = '" + course + "'";

        return super.query(sql, null, Train.class);
    }


    @Override
    public List<Train> findAllTrain() {
        String sql = "select * from system_ysh.train;";

        return super.query(sql, null, Train.class);
    }
    @Override
    public int modifyTwoTrainIsTrainingDao(int trainId) {
        String sql = "update system_ysh.train set isTraining = ? where id = " + trainId;

        Object[] parameters = {2};

        return super.update(sql, parameters);
    }

    @Override
    public int modifyTwoTrainingCourseIsTrainingDao(int trainId) {
        String sql = "update system_ysh.training_course set isTraining = ? where id = " + trainId;

        Object[] parameters = {2};

        return super.update(sql, parameters);
    }

    @Override
    public int modifyOneTrainIsTrainingDao(int trainId) {
        String sql = "update system_ysh.train set isTraining = ? where id = " + trainId;

        Object[] parameters = {1};

        return super.update(sql, parameters);
    }
    @Override
    public int modifyOneTrainingCourseIsTrainingDao(int trainId) {
        String sql = "update system_ysh.training_course set isTraining = ? where id = " + trainId;

        Object[] parameters = {1};

        return super.update(sql, parameters);
    }

    @Override
    public List<TrainingCourse> findByIdTrainCourseDao(int trainingCourseId) {
        String sql = "select * from system_ysh.training_course where id = " + trainingCourseId;

        return super.query(sql, null, TrainingCourse.class);
    }

    @Override
    public int addTrainingCourseDao(TrainingCourse trainingCourse) {
        String sql = "insert into system_ysh.training_course (course, beginTime, endTime, teacher, isTraining) values (?,?,?,?,0)";

        Object[] parameters = {trainingCourse.getCourse(), trainingCourse.getBeginTime(), trainingCourse.getEndTime(), trainingCourse.getTeacher()};

        return super.update(sql, parameters);
    }

    @Override
    public int deleteTrainingCourseDao(int trainingCourseId) {
        String sql = "delete from system_ysh.training_course where id = " + trainingCourseId;

        return update(sql, null);
    }











    // 工资模块

    @Override
    public int addSalaryDao(Salary salary) {
        String sql = "insert into system_ysh.salary (userId, name, basic, eat, house, duty, punishment, other, grantTime, totalize) values (?,?,?,?,?,?,?,?,?,?);";

        Object[] parameters = {salary.getUserId(), salary.getName(), salary.getBasic(), salary.getEat(), salary.getHouse(), salary.getDuty(), salary.getPunishment(), salary.getOther(), salary.getGrantTime(), salary.getTotalize()};

        return super.update(sql, parameters);
    }

    @Override
    public int deleteSalaryDao(int salaryId) {
        String sql = "delete from system_ysh.salary where id = " + salaryId;

        return super.update(sql, null);
    }
    @Override
    public int modifySalaryDao(Salary salary) {
        String sql = "update system_ysh.salary set userId = ?, name = ?, basic = ?, eat = ?, house = ?, duty = ?, punishment = ?, other = ?, grantTime = ?, totalize = ? where id = ?;";

        // 获取worker里的参数保存到parameters数组里面
        Object[] parameters = {salary.getUserId(), salary.getName(), salary.getBasic(), salary.getEat(), salary.getHouse(), salary.getDuty(), salary.getPunishment(), salary.getOther(), salary.getGrantTime(), salary.getTotalize(), salary.getId()};

        return super.update(sql, parameters);
    }
    @Override
    public List<Salary> findByIdSalaryDao(int salaryId) {
        String sql = "select * from system_ysh.salary where userId = " + salaryId;

        return super.query(sql, null, Salary.class);
    }

    @Override
    public List<Salary> findAllSalaryDao() {
        String sql = "select * from system_ysh.salary;";

        return super.query(sql, null, Salary.class);
    }





    @Override
    public int addApplicantDao(Applicant applicant) {
        String sql = "insert into system_ysh.applicant (name, gender, age, IDNumber, department, job, speciality, experience, education, school, tel, email, createTime, isHiring) values (?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        Object[] parameters = {applicant.getName(), applicant.isGender(), applicant.getAge(), applicant.getIDNumber(), applicant.getDepartment(), applicant.getJob(), applicant.getSpeciality(), applicant.getExperience(), applicant.getEducation(), applicant.getSchool(), applicant.getTel(), applicant.getEmail(), applicant.getCreateTime()};

        return super.update(sql, parameters);
    }

    @Override
    public int deleteApplicantDao(int deleteApplicantId) {
        String sql = "delete from system_ysh.applicant where id = " + deleteApplicantId;

        return super.update(sql, null);
    }

    @Override
    public int deleteApplicantIsHiringDao() {
        String sql = "delete from system_ysh.applicant where isHiring = 0";

        return super.update(sql, null);
    }

    @Override
    public int modifyApplicantIsHiringDao(int applicantId) {
        String sql = "update system_ysh.applicant set isHiring = ? where id = " + applicantId;

        Object[] parameters = {1};

        return super.update(sql, parameters);
    }

    public List<Applicant> findByIdApplicant(int applicantId) {
        String sql = "select * from system_ysh.applicant where id = " + applicantId;

        return super.query(sql, null, Applicant.class);
    }

    @Override
    public List<Applicant> findAllApplicant() {
        String sql = "select * from system_ysh.applicant;";

        return super.query(sql, null, Applicant.class);
    }

    @Override
    public List<Applicant> findByIdApplicantDao(int applicantId) {
        String sql = "select * from system_ysh.applicant where id = " + applicantId;

        return super.query(sql, null, Applicant.class);
    }

    @Override
    public List<Applicant> findThePassDao() {
        String sql = "select * from system_ysh.applicant where isHiring = 1";

        return super.query(sql, null, Applicant.class);
    }







}
