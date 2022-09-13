package com.jxonline.sword.service.api;

import com.jxonline.sword.entity.UserInfoModel;


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
}
