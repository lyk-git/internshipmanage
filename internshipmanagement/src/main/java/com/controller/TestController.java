package com.controller;


import com.form.LoginForm;
import com.form.StudentForm;
import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.service.LoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login");
        return mv;
    }
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }
    @RequestMapping(value = "/api/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView loginveriftyea(@RequestBody LoginForm loginForm){
        Student student=new Student();
        student.setId(loginForm.getUid());
        student.setPassword(loginForm.getPwd());
        if(loginService.validate(student).equals("登陆成功")){
            return new ModelAndView("index");
        };
        return new ModelAndView("index");

    }
    @RequestMapping(value = "/user/profile",method = RequestMethod.GET)
    public StudentForm getUserForm(@RequestParam("uid") String uid){

        return studentService.getSudentInf(uid);
    }
    @RequestMapping(value = "/api/me/{id}",method = RequestMethod.GET)
    public StudentForm getUserForm12(@PathVariable("id") String id){
        if(id.equals("0"))id="MF1732001";
        return studentService.getSudentInf(id);
    }
    @RequestMapping(value = "/api/profile/{id}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentForm setUserForm(@PathVariable("id") String id,@RequestBody Map student){
        if(id.equals("0"))id="MF1732001";
        StudentForm studentForm=new StudentForm();
        studentForm.setUid((String)student.get("sid"));

        studentForm.setName((String)student.get("name"));
        studentForm.setTel((String)student.get("tel"));
        studentService.modify_StudentInf(id,studentForm);


        return studentService.getSudentInf(id);
    }
    @RequestMapping(value = "/api/profile/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, String> setUserForm(@PathVariable("id") String id){
        if(id.equals("0"))id="MF1732001";
        StudentForm studentForm=studentService.getSudentInf(id);
        HashMap<String,String> hashMap=new HashMap();
        hashMap.put("name",studentForm.getName());
        hashMap.put("sid",studentForm.getUid());
        hashMap.put("grade","2.1");
        hashMap.put("email",studentForm.getTel());
        hashMap.put("qq",studentForm.getQq());
        hashMap.put("wechat",studentForm.getWechat());
        return hashMap;

    }
}
