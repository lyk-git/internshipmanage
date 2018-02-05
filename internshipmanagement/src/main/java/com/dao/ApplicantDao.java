package com.dao;

import com.model.Applicant;
import org.springframework.stereotype.Component;

import java.util.List;
public interface ApplicantDao {
    public List query();
    public List query(Applicant applicant);
    public void delete(String id);
    public void modify(String id, Applicant newapplicant);
    public void add(Applicant applicant);
}
