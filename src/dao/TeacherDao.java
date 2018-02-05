package dao;

import model.Teacher;

import java.util.List;

public interface TeacherDao {
    public List query();
    public List query(Teacher teacher);
    public void delete(String id);
    public void modify(String id, Teacher newteacher);
    public void add(Teacher teacher);
}
