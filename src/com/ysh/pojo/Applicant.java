package com.ysh.pojo;
/**
 * Applicant实体类
 *
 * @author Anonymous
 * @date 2019-10-10 15:14
 */
public class Applicant {
    private int id;
    private String name;
    private boolean gender;
    private short age;
    private String IDNumber;
    private String department;
    private String job;
    private String speciality;

    /**
     *工作经验
     */
    private String experience;
    /**
     * 学历
     */
    private String education;
    private String school;
    private String tel;
    private String email;
    private String createTime;
    private boolean isHiring;

    public Applicant() {
    }

    public Applicant(int id, String name, boolean gender, short age, String IDNumber, String department, String job, String speciality, String experience, String education, String school, String tel, String email, String createTime, boolean isHiring) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.IDNumber = IDNumber;
        this.department = department;
        this.job = job;
        this.speciality = speciality;
        this.experience = experience;
        this.education = education;
        this.school = school;
        this.tel = tel;
        this.email = email;
        this.createTime = createTime;
        this.isHiring = isHiring;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isHiring() {
        return isHiring;
    }

    public void setHiring(boolean hiring) {
        isHiring = hiring;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", IDNumber='" + IDNumber + '\'' +
                ", department='" + department + '\'' +
                ", job='" + job + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isHiring=" + isHiring +
                '}';
    }
}
