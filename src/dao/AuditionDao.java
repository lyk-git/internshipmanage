package dao;

import model.Audition;

import java.util.List;

public interface AuditionDao {
    public List query();
    public List query(Audition audition);
    public void delete(String id);
    public void modify(String id, Audition newaudition);
    public void add(Audition audition);
}
