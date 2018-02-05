package com.service;

import com.form.StudentForm;
import com.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public void modify_StudentInf(String id,StudentForm student);
    public StudentForm getSudentInf(String id);
}
