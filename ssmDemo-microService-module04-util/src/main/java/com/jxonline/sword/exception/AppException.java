package com.jxonline.sword.exception;

import com.jxonline.sword.constant.ResultCodeEnum;

/**
 *
 * 自定义异常
 * @author xs
 * @date 2022/9/15
 **/
public class AppException extends RuntimeException{

    private int code = 500;
    private String msg = "服务器异常";

    public AppException(ResultCodeEnum resultCodeEnum){
        super();
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    public AppException(int code , String msg){
        super();
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
