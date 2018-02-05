package com.service;

import com.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public interface LoginService {
    public String validate(Student student);
}
