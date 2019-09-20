package com.controller;

public class ResultInfo {
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

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    private Integer code;
    //返回接口调用消息提示，成功返回success，失败返回对应的失败信息
    private String msg;
    //返回的执行结果集
    private Object info;

}
