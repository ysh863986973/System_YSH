package com.ysh.pojo;

/**
 * User实体类
 *
 * @author Anonymous
 * @date 2019-10-09 10:59
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String name;
    private int age;
    private boolean gender;
    private String IDNumber;
    private String basicSalary;
    private String department;
    private String job;
    private String createTime;
    private String content;
    private int roleId;

    public User() { }

    public User(int id, String userName, String password, String name, int age, boolean gender, String IDNumber, String basicSalary, String department, String job, String createTime, String content, int roleId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.IDNumber = IDNumber;
        this.basicSalary = basicSalary;
        this.department = department;
        this.job = job;
        this.createTime = createTime;
        this.content = content;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", IDNumber='" + IDNumber + '\'' +
                ", salary='" + basicSalary + '\'' +
                ", department='" + department + '\'' +
                ", job='" + job + '\'' +
                ", createTime='" + createTime + '\'' +
                ", content='" + content + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
