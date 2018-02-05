
package com.daoimp;

import com.dao.AuditionDao;
import com.model.Audition;
import com.model.MySessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditionDaoImp implements AuditionDao
{
    @Autowired
    public static MySessionFactory mysessionfactory;

    public List query()
    {
        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Audition.class);
        list = c.list();
        return list;
    }
    public List query(Audition audition)
    {

        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Audition.class);
        String a;
        Byte b;
        if((a=audition.getApplicantid())!=null) c.add(Restrictions.eq("applicantid", a));
        if((a=audition.getCounselloropinion())!=null) c.add(Restrictions.eq("counselloropinion", a));
        if((a=audition.getCreditackopinion())!=null) c.add(Restrictions.eq("creditackopinion", a));
        if((a=audition.getEngineerteacheropinion())!=null) c.add(Restrictions.eq("engineerteacheropinion", a));
        if((a=audition.getProjectteacheropinion())!=null) c.add(Restrictions.eq("projectteacheropinion", a));
        if((a=audition.getStudentid())!=null) c.add(Restrictions.eq("studentid", a));
        if((a=audition.getTutoropinion())!=null) c.add(Restrictions.eq("tutoropinion", a));

        list = c.list();
        return list;
    }


    public void delete(String id)
    {
        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Audition audition;

        audition = session.load(Audition.class, id);
        session.delete(audition);
        tx.commit();
    }
    public void modify(String id, Audition newaudition)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Audition audition;
        audition = session.load(Audition.class, id);
        audition.setApplicantid(newaudition.getApplicantid());
        audition.setCounselloropinion(newaudition.getCounselloropinion());
        audition.setCreditackopinion(newaudition.getCreditackopinion());
        audition.setEngineerteacheropinion(newaudition.getEngineerteacheropinion());
        audition.setProjectteacheropinion(newaudition.getProjectteacheropinion());
        audition.setStudentid(newaudition.getStudentid());
        audition.setTutoropinion(newaudition.getTutoropinion());
        tx.commit();
    }
    public void add(Audition audition)
    {
        Session session = mysessionfactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(audition);
        tx.commit();
    }

    public static void main(final String[] args) throws Exception {
        AuditionDaoImp sd=new AuditionDaoImp();
        Byte b=1;
        //Student student=new Student("MF1732002","185431414","2141414@qq.com","1324155161","13124155","cx","123456","13424252",b);
        //
        Audition student=new Audition();
        student.setApplicantid("12311");

        //sd.add(student);
        List list=sd.query(student);
        System.out.print(((Audition)list.get(0)).getApplicantid());
    }
}
