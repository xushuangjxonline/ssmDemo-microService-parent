package com.jxonline.sword.constant;

/**
 * 响应码的枚举类
 * @author xs
 * @date 2022/9/14
 **/
public enum ResultCodeEnum {

    //参数错误
    PARAM_IS_INVALID(1001,"参数错误"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),
    INVALID_CODE(1005,"验证码无效"),

    //用户错误
    USER_NOT_LOGGED_IN(2001,"用尚未登录,请登录"),
    USER_NOT_EXIST_ERROE(2002,"账号不存在"),
    USER_HAS_EXIST_ERROE(2003,"账号已存在"),
    USER_LOGIN_ERREOR(2004,"账号或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2005,"账号已被禁用");

    //功能操作失败常量  TODO



    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
