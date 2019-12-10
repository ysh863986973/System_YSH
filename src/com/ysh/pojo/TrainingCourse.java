package com.ysh.pojo;

public class TrainingCourse {
    private int id;
    private String course;
    private String beginTime;
    private String endTime;
    private String teacher;
    private int isTraining;
    private int grade;

    public TrainingCourse() {
    }

    public TrainingCourse(int id, String course, String beginTime, String endTime, String teacher, int isTraining, int grade) {
        this.id = id;
        this.course = course;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.isTraining = isTraining;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "TrainingCourse{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", teacher='" + teacher + '\'' +
                ", isTraining=" + isTraining +
                ", grade=" + grade +
                '}';
    }
}
