package com.ysh.pojo;

public class Salary {
    private int id;
    private String userId;
    private String name;
    private double basic; // 基本工资
    private double eat;
    private double house;
    private double duty; // 税
    private double punishment; // 惩罚
    private double other;
    private String grantTime; // 发工资时间
    private double totalize; // 总计

    public Salary() {
    }

    public Salary(int id, String userId, String name, double basic, double eat, double house, double duty, double punishment, double other, String grantTime, double totalize) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.basic = basic;
        this.eat = eat;
        this.house = house;
        this.duty = duty;
        this.punishment = punishment;
        this.other = other;
        this.grantTime = grantTime;
        this.totalize = totalize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getEat() {
        return eat;
    }

    public void setEat(double eat) {
        this.eat = eat;
    }

    public double getHouse() {
        return house;
    }

    public void setHouse(double house) {
        this.house = house;
    }

    public double getDuty() {
        return duty;
    }

    public void setDuty(double duty) {
        this.duty = duty;
    }

    public double getPunishment() {
        return punishment;
    }

    public void setPunishment(double punishment) {
        this.punishment = punishment;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public double getTotalize() {
        return totalize;
    }

    public void setTotalize(double totalize) {
        this.totalize = totalize;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", basic=" + basic +
                ", eat=" + eat +
                ", house=" + house +
                ", duty=" + duty +
                ", punishment=" + punishment +
                ", other=" + other +
                ", grantTime='" + grantTime + '\'' +
                ", totalize=" + totalize +
                '}';
    }
}
