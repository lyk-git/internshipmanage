
package com.daoimp;

import com.dao.TeacherDao;
import com.model.MySessionFactory;
import com.model.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImp implements TeacherDao
{
    @Autowired
    public static MySessionFactory mysessionfactory;



    public List query()
    {
        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Teacher.class);
        list = c.list();
        return list;
    }
    public List query(Teacher teacher)
    {

        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Teacher.class);
        String a;
        Byte b;
        if((b=teacher.getIsengineerteacher())!=null) c.add(Restrictions.eq("isengineerteache", b));
        if((a=teacher.getCallnumber())!=null) c.add(Restrictions.eq("callnumber", a));
        if((a=teacher.getEmail())!=null) c.add(Restrictions.eq("email", a));
        if((a=teacher.getName())!=null) c.add(Restrictions.eq("name", a));
        if((a=teacher.getPassword())!=null) c.add(Restrictions.eq("password", a));
        if((a=teacher.getQq())!=null) c.add(Restrictions.eq("qq", a));
        if((a=teacher.getId())!=null) c.add(Restrictions.eq("id", a));
        if((a=teacher.getWechat())!=null) c.add(Restrictions.eq("wechat", a));

        list = c.list();
        return list;
    }


    public void delete(String id)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Teacher teacher;

        teacher = session.load(Teacher.class, id);
        session.delete(teacher);
        tx.commit();
    }
    public void modify(String id, Teacher newteacher)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Teacher teacher;
        teacher = session.load(Teacher.class, id);
        teacher.setIsengineerteacher(newteacher.getIsengineerteacher());
        teacher.setCallnumber(newteacher.getCallnumber());
        teacher.setEmail(newteacher.getEmail());
        teacher.setName(newteacher.getName());
        teacher.setPassword(newteacher.getPassword());
        teacher.setQq(newteacher.getQq());
        teacher.setWechat(newteacher.getWechat());

        tx.commit();
    }
    public void add(Teacher teacher)
    {

        Session session = mysessionfactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(teacher);
        tx.commit();
    }

    public static void main(final String[] args) throws Exception {
        TeacherDaoImp sd=new TeacherDaoImp();
        Byte b=1;
        //Student student=new Student("MF1732002","185431414","2141414@qq.com","1324155161","13124155","cx","123456","13424252",b);
        //
        Teacher student=new Teacher();
        student.setId("3456789");
        student.setPassword("1234567");
        sd.modify("3456789",student);
        List list=sd.query(student);
        System.out.print(((Teacher)list.get(0)).getId());

        System.out.print(((Teacher)list.get(0)).getPassword());
    }
}
