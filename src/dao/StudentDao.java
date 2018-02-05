package dao;
import model.Student;
import java.util.List;

public interface StudentDao {
    public List query();
    public List query(Student student);
    public void delete(String id);
    public void modify(String id,Student newstudent);
    public void add(Student student);
}
