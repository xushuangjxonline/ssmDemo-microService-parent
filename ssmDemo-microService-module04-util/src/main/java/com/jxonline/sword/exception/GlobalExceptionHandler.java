package com.jxonline.sword.exception;

import com.jxonline.sword.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局自定义异常
 * @author xs
 * @date 2022/9/15
 **/

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> Result<T> exceptionHandler(Exception e){
        e.printStackTrace();
        //先判断拦截到的异常是不是自定义异常类型
        if(e instanceof AppException){
            AppException appException = (AppException)e;
            return Result.error(appException.getCode(),appException.getMsg());
        }
        //如果拦截的异常不是自定义的异常(例如 数据库主键冲突)
        return Result.error(500,"服务器端异常");
    }
}
