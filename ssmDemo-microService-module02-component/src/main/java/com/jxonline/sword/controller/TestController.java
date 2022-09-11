package com.jxonline.sword.controller;

import com.jxonline.sword.entity.UserInfoModel;
import com.jxonline.sword.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xs
 * @date 2022/9/11
 **/

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    TestService testServiceimpl;

    @GetMapping(value = "/test")
    public  ModelAndView testTest(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfoModel> list = testServiceimpl.selectUserInfoModel();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
