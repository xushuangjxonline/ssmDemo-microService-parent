package com.jxonline.sword.util;

import com.jxonline.sword.constant.ResultCodeEnum;


/**
 * 统一返回结果集
 * @author xs
 * @date 2022/9/14
 **/
public class Result<T> {


    //返回的状态码
    private Integer code;

    //返回的消息
    private String msg;

    //返回封装的数据
    private T data;


    public static <T>Result<T> putResultMap(ResultCodeEnum resultCodeEnum,T data){
        return new Result(
                resultCodeEnum.getCode(),
                resultCodeEnum.getMessage(),
                data
                );
    }

    //请求成功的方法
    public static  <T>Result<T> success(T data){
        return new Result(200,"请求成功",data);
    }

    //请求失败的方法
    public static  <T>Result<T> fail(){
        return new Result(400,"请求失败",null);
    }

    //异常的结果集
    public static <T>Result<T> error(ResultCodeEnum resultCodeEnum){
        return new Result(
                resultCodeEnum.getCode(),
                resultCodeEnum.getMessage(),
                null);
    }

    public static <T>Result<T> error(int code ,String msg){
        return new Result(code,msg,null);
    }


    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}









