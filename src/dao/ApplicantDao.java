package dao;

import model.Applicant;

import java.util.List;

public interface ApplicantDao {
    public List query();
    public List query(Applicant applicant);
    public void delete(String id);
    public void modify(String id, Applicant newapplicant);
    public void add(Applicant applicant);
}
