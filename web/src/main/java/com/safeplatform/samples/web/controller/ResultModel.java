package com.safeplatform.samples.web.controller;

public class ResultModel {

    private int errCode;
    private String msg;

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    public ResultModel() {

    }
    public ResultModel(int errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }


}