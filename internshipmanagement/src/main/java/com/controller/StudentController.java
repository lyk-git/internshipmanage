package com.controller;


import com.form.StudentForm;
import com.model.Student;
import com.service.LoginService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/informationsubmit.htm")
    public  String information_modify(ModelAndView model, @RequestBody StudentForm studentForm){
        studentService.modify_StudentInf(studentForm.getUid(),studentForm);
        return "true";
    }
    @RequestMapping("/informationform.htm")
    public StudentForm getinformation(@RequestParam String id){
        Student student=new Student();
        student.setId(id);
        return studentService.getSudentInf(id);
    }
}
