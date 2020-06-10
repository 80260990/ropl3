package com.itheima.ssm.domain;

/**
 * @Classname Traveller
 * @Description TODO
 * @Date 2020/5/18 13:25
 * @Created by Leslie
 */
public class Traveller {
    private int id;
    private String travellerName;
    private String travellerSex;
    private String travellerPhone;
    private String travellerIdType;
    private String travellerIdNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getTravellerSex() {
        return travellerSex;
    }

    public void setTravellerSex(String travellerSex) {
        this.travellerSex = travellerSex;
    }

    public String getTravellerPhone() {
        return travellerPhone;
    }

    public void setTravellerPhone(String travellerPhone) {
        this.travellerPhone = travellerPhone;
    }

    public String getTravellerIdType() {
        return travellerIdType;
    }

    public void setTravellerIdType(String travellerIdType) {
        this.travellerIdType = travellerIdType;
    }

    public String getTravellerIdNum() {
        return travellerIdNum;
    }

    public void setTravellerIdNum(String travellerIdNum) {
        this.travellerIdNum = travellerIdNum;
    }
}
