package com.serviceimp;

import com.dao.StudentDao;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.LoginService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginServiceImp implements LoginService{
    @Autowired
    StudentDao studentDao;
    @Override
    public String validate(Student student) {
        List list=studentDao.query(student);
        if(list.isEmpty())return"用户名或密码错误";
        Student student1=(Student)list.get(0);
        if(student.getPassword().equals(student1.getPassword()))return "登陆成功";
        return "";

    }
}
