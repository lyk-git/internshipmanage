package com.serviceimp;

import com.dao.StudentDao;
import com.form.StudentForm;
import com.model.Student;
import com.service.LoginService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public void modify_StudentInf(String id,StudentForm student) {
        Student new_student=new Student();
        new_student.setId(student.getUid());
        new_student.setEmail(student.getEmail());
        new_student.setName(student.getName());
        new_student.setQq(student.getQq());
        new_student.setCallnumber(student.getTel());
        new_student.setWechat(student.getWechat());
        studentDao.modify(id,new_student);
    }



    @Override
    public StudentForm getSudentInf(String id) {
        Student student=new Student();
        student.setId(id);
        List<Student> students=studentDao.query(student);
        if(students.isEmpty())return null;
        student=students.get(0);
        StudentForm studentForm=new StudentForm();
        studentForm.setEmail(student.getEmail());
        studentForm.setUid(student.getId());
        studentForm.setName(student.getName());
        studentForm.setQq(student.getQq());
        studentForm.setTel(student.getCallnumber());
        studentForm.setWechat(student.getWechat());
        return studentForm;
    }
}
