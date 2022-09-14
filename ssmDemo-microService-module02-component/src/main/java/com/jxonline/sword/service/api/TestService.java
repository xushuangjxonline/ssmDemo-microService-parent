package com.jxonline.sword.service.api;

import com.jxonline.sword.entity.UserInfoModel;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author xs
 * @date 2022/9/11
 **/


public interface TestService {

    //查询userinfo表的数据
    List<UserInfoModel> selectUserInfoModel();

    //简单的ajax登录 测试thymeleaf表单
    UserInfoModel doLogin(String username,String password);

    //是否存在该账户--存在,则提示账户或密码错误----不存在,则提示不存在该账户
    Boolean isHaveAccount(String username);
}
