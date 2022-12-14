package com.jxonline.sword.service.impl;

import com.jxonline.sword.entity.UserInfoModel;
import com.jxonline.sword.mapper.TestMapper;
import com.jxonline.sword.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @ author xs
 * @ date 2022/9/11
 **/

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public List<UserInfoModel> selectUserInfoModel() {

        return testMapper.selectUserInfoModel();
    }

    @Override
    public UserInfoModel doLogin(String username, String password) {
        List<UserInfoModel> list = testMapper.doLogin(username,password);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Boolean isHaveAccount(String username) {
        return testMapper.isHaveAccount(username);
    }


}
