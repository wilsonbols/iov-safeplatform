package com.safeplatform.samples.web.dao;

import java.util.Date;

public class Collision {
    private Integer id;

    private String vin;

    private String state;

    private String locationinfo;

    private String collisioninfo;

    private String descriptioninfo;

    private String assignee;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocationinfo() {
        return locationinfo;
    }

    public void setLocationinfo(String locationinfo) {
        this.locationinfo = locationinfo;
    }

    public String getCollisioninfo() {
        return collisioninfo;
    }

    public void setCollisioninfo(String collisioninfo) {
        this.collisioninfo = collisioninfo;
    }

    public String getDescriptioninfo() {
        return descriptioninfo;
    }

    public void setDescriptioninfo(String descriptioninfo) {
        this.descriptioninfo = descriptioninfo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}