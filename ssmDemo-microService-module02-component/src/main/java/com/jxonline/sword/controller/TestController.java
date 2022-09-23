package com.jxonline.sword.controller;

import com.jxonline.sword.constant.ResultCodeEnum;
import com.jxonline.sword.entity.UserInfoModel;
import com.jxonline.sword.service.api.TestService;
import com.jxonline.sword.util.JsonUtil;
import com.jxonline.sword.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author xs
 * @date 2022/9/11
 **/

@RestController
@RequestMapping("/")
public class TestController {


    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testServiceimpl;


    @GetMapping("/showList")
    public ModelAndView testTest(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfoModel> list = testServiceimpl.selectUserInfoModel();
        UserInfoModel user = list.get(0);
        modelAndView.addObject("list",list);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("test");
        if(LOGGER.isDebugEnabled()){
            LOGGER.info("该方法调用 {}" ,testServiceimpl);
        }
        return modelAndView;
    }

    @GetMapping("/getJson")
    public String getJson(){
        List<UserInfoModel> list = testServiceimpl.selectUserInfoModel();
        return Result.success(list);
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestBody String jsonPara, HttpSession session){

        Map map = JsonUtil.jsonStr2Map(jsonPara,Map.class);

        String username = map.get("username").toString();
        String password = map.get("password").toString();

        if(testServiceimpl.doLogin(username,password) != null){
            UserInfoModel userInfo = testServiceimpl.doLogin(username,password);
            session.setAttribute("userInfo",userInfo);
            return Result.success(userInfo);
        }else if (testServiceimpl.isHaveAccount(username)){
            return Result.error(ResultCodeEnum.USER_LOGIN_ERREOR);
        }else if("1111".equals(username)){
            int q = 1/0;
        }
        return Result.error(ResultCodeEnum.USER_NOT_EXIST_ERROE);
    }
}
