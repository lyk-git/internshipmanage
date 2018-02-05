package dao;

import model.Recruitment;

import java.util.List;

public interface RecruitmentDao {
    public List query();
    public List query(Recruitment recruitment);
    public void delete(String id);
    public void modify(String id, Recruitment newrecruitment);
    public void add(Recruitment recruitment);
}
