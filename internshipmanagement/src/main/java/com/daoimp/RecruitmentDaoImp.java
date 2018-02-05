package com.daoimp;

import com.dao.RecruitmentDao;
import com.model.MySessionFactory;
import com.model.Recruitment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecruitmentDaoImp implements RecruitmentDao {

    @Autowired
    public static MySessionFactory mysessionfactory;


    public List query()
    {
        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Recruitment.class);
        list = c.list();
        return list;
    }
    public List query(Recruitment recruitment)
    {
        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Recruitment.class);
        String a;
        if((a=recruitment.getContent())!=null) c.add(Restrictions.eq("content", a));
        if((a=recruitment.getId())!=null) c.add(Restrictions.eq("id", a));
        if((a=recruitment.getPublisher())!=null) c.add(Restrictions.eq("publisher", a));
        list = c.list();
        return list;
    }


    public void delete(String id)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Recruitment recruitment;

        recruitment = session.load(Recruitment.class, id);
        session.delete(recruitment);
        tx.commit();
    }
    public void modify(String id, Recruitment newrecruitment)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Recruitment recruitment;
        recruitment =  session.load(Recruitment.class, id);
        recruitment.setContent(newrecruitment.getContent());
        recruitment.setPublisher(newrecruitment.getPublisher());
        tx.commit();
    }
    public void add(Recruitment recruitment)
    {

        Session session = mysessionfactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(recruitment);
        tx.commit();
    }
}
