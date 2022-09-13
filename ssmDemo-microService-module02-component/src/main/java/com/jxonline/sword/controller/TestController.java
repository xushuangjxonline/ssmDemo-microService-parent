package com.jxonline.sword.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jxonline.sword.entity.UserInfoModel;
import com.jxonline.sword.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xs
 * @date 2022/9/11
 **/

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    TestService testServiceimpl;

    @GetMapping("/showList")
    public  ModelAndView testTest(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfoModel> list = testServiceimpl.selectUserInfoModel();
        UserInfoModel user = list.get(0);
        modelAndView.addObject("list",list);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("test");
        session.setAttribute("list",list);
        return modelAndView;
    }

    @GetMapping("/getJson")
    @ResponseBody
    public  String getJson() throws JsonProcessingException {
        List<UserInfoModel> list = testServiceimpl.selectUserInfoModel();
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(list);
        return jsonStr;
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public Map<String , Object> doLogin(@RequestBody Object jsonPara, HttpSession session)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String , Object> resultMap = new HashMap();
        Map map =mapper.readValue(mapper.writeValueAsString(jsonPara),Map.class);
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        if(testServiceimpl.doLogin(username,password) != null){
            UserInfoModel userInfo = testServiceimpl.doLogin(username,password);
            session.setAttribute("userInfo",userInfo);
            resultMap.put("code",200);
            resultMap.put("message","登录成功");
            resultMap.put("data",userInfo);
            return resultMap;
        }else {
            resultMap.put("code",400);
            resultMap.put("message","登陆失败");
            resultMap.put("data",null);
            return resultMap;
        }
    }
}
