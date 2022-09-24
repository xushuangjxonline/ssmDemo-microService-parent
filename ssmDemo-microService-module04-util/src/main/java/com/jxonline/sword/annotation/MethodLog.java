package com.jxonline.sword.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解  给方法的执行时间 入参 结果打日志
 * @author xs
 * @date 2022/9/24
 **/
//表示是 用在方法上的注解
@Target(ElementType.METHOD)
//@Retention作用是 定义被他所注解的注解生命周期,runtime运行时保留
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLog {
}
