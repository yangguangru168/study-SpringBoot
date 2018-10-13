package com.hand.girl.girlenum;

import lombok.Data;

public enum  ResultEnum {
    UNKNOWN(-1,"系统异常"),
    SUCCESS(1,"成功了"), 
    M_SCHOOL(100,"还在上小学"),
    H_SCHOOL(10,"还在上中学多少");
    private Integer code;
    private String msg;
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
