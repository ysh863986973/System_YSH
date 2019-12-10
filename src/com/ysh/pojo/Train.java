package com.ysh.pojo;

/**
 * Train培训实体类
 *
 * @author Anonymous
 * @date 2019-10-02 11:18
 */

public class Train {
    private int id;
    private int studentId;
    private String name;
    private String course;
    private String beginTime;
    private String endTime;
    private String teacher;
    /**
     * 目标
     */
    private String goal;
    /**
     * 影响
     */
    private String effect;
    private int isTraining;
    private int grade;

    public Train() {
    }

    public Train(int id, int studentId, String name, String course, String beginTime, String endTime, String teacher, String goal, String effect, int isTraining, int grade) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.goal = goal;
        this.effect = effect;
        this.isTraining = isTraining;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getIsTraining() {
        return isTraining;
    }

    public void setIsTraining(int isTraining) {
        this.isTraining = isTraining;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", teacher='" + teacher + '\'' +
                ", goal='" + goal + '\'' +
                ", effect='" + effect + '\'' +
                ", isTraining=" + isTraining +
                ", grade=" + grade +
                '}';
    }
}
