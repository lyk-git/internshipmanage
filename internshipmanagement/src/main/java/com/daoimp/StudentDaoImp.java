
package com.daoimp;

import com.dao.StudentDao;
import com.model.MySessionFactory;
import com.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao
{
    @Autowired
    public static MySessionFactory mysessionfactory;


    public List query()
    {
        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Student.class);
        list = c.list();
        return list;
    }
    public List query(Student student)
    {


        Session session = mysessionfactory.getSession();
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
        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Student student;

        student = session.load(Student.class, id);
        session.delete(student);
        tx.commit();
    }
    public void modify(String id, Student newstudent)
    {
        Session session = mysessionfactory.getSession();

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

        Session session = mysessionfactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
    }

    public static void main(final String[] args) throws Exception {
        StudentDaoImp sd=new StudentDaoImp();
        Byte b=1;
        //Student student=new Student("MF1732002","185431414","2141414@qq.com","1324155161","13124155","cx","123456","13424252",b);
        //
        Student student=new Student("MF173200",null,null,null,null,"曹鑫",null,null,null);
        sd.add(student);
        System.out.print(student.getName());
    }
}
