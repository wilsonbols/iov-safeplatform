package com.safeplatform.samples.web.controller;

public class CarDoorModel {

    private String vin;
    private String device;
    private String action;
    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getVin() {
        return vin;
    }

    public void setDevice(String device) {
        this.device = device;
    }
    public String getDevice() {
        return device;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }

}