
package daoimp;

import dao.StudentDao;
import model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao
{
    public static SessionFactory mysessionfactory;

    public static void setMysessionfactory(SessionFactory mysessionfactory) {
        StudentDaoImp.mysessionfactory = mysessionfactory;
    }

    public List query()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        List list;
        Criteria c = session.createCriteria(Student.class);
        list = c.list();
        return list;
    }
    public List query(Student student)
    {

        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        List list;
        Criteria c = session.createCriteria(Student.class);
        String a;
        Byte b;
        if((b=student.getAnnouncerecruit())!=null) c.add(Restrictions.eq("annoucerecuit", b));
        if((a=student.getCallnumber())!=null) c.add(Restrictions.eq("callnumber", a));
        if((a=student.getEmail())!=null) c.add(Restrictions.eq("email", a));
        if((a=student.getInternship())!=null) c.add(Restrictions.eq("internship", a));
        if((a=student.getName())!=null) c.add(Restrictions.eq("name", a));
        if((a=student.getPassword())!=null) c.add(Restrictions.eq("password", a));
        if((a=student.getQq())!=null) c.add(Restrictions.eq("qq", a));
        if((a=student.getId())!=null) c.add(Restrictions.eq("id", a));
        if((a=student.getWechat())!=null) c.add(Restrictions.eq("wechat", a));

        list = c.list();
        return list;
    }


    public void delete(String id)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Student student;

        student = session.load(Student.class, id);
        session.delete(student);
        tx.commit();
    }
    public void modify(String id,Student newstudent)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Student student;
        student = session.load(Student.class, id);
        student.setAnnouncerecruit(newstudent.getAnnouncerecruit());
        student.setCallnumber(newstudent.getCallnumber());
        student.setEmail(newstudent.getEmail());
        student.setInternship(newstudent.getInternship());
        student.setName(newstudent.getName());
        student.setPassword(newstudent.getPassword());
        student.setQq(newstudent.getQq());
        student.setWechat(newstudent.getWechat());

        tx.commit();
    }
    public void add(Student student)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
    }

    public static void main(final String[] args) throws Exception {
        StudentDaoImp sd=new StudentDaoImp();
        Byte b=1;
        //Student student=new Student("MF1732002","185431414","2141414@qq.com","1324155161","13124155","cx","123456","13424252",b);
        //
        Student student=new Student("MF1732001",null,null,null,null,null,null,null,null);
        //sd.add(student);
        List list=sd.query(student);
        System.out.print(((Student)list.get(0)).getId());
    }
}
