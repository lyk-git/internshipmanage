package com.controller;


import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.service.LoginService;

import javax.servlet.http.HttpSession;

@RestController
public class TestController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login.htm")
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login");
        return mv;
    }


    @RequestMapping("/login_validate.htm")
    public ModelAndView login_val(ModelAndView model, @RequestParam String user_name, @RequestParam String user_pwd){
        Student student=new Student();
        student.setId(user_name);
        student.setPassword(user_pwd);
        String result=loginService.validate(student);

        if(result.equals("登陆成功")) {
            model.setViewName("index");
        }
        else {
            model.setViewName("login");
        }
        return model;
    }
}
