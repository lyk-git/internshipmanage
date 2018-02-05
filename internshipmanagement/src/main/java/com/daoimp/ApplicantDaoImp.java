package com.daoimp;

import com.dao.ApplicantDao;
import com.model.Applicant;
import com.model.MySessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class ApplicantDaoImp implements ApplicantDao {
    @Autowired
    public MySessionFactory mysessionfactory;


    public List query()
    {

        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Applicant.class);
        list = c.list();
        return list;
    }
    public List query(Applicant applicant)
    {

        Session session = mysessionfactory.getSession();
        List list;
        Criteria c = session.createCriteria(Applicant.class);
        String a;
        Byte b;
        Date d;
        int i;
        if((a=applicant.getApplyreason())!=null) c.add(Restrictions.eq("applyreason", a));
        if((a=applicant.getCompanyaddress())!=null) c.add(Restrictions.eq("companyaddress", a));
        if((a=applicant.getCompanyconnectpeople())!=null) c.add(Restrictions.eq("companyconnectpeople", a));
        if((a=applicant.getCompanyconnectpeoplejob())!=null) c.add(Restrictions.eq("companyconnectpeoplejob", a));
        if((a=applicant.getHelpteacher())!=null) c.add(Restrictions.eq("helpteacher", a));
        if((a=applicant.getCompanynaMe())!=null) c.add(Restrictions.eq("companynaMe", a));
        if((a=applicant.getId())!=null) c.add(Restrictions.eq("id", a));
        if((a=applicant.getJobgetway())!=null) c.add(Restrictions.eq("jobgetway", a));
        if((a=applicant.getProjectteacher())!=null) c.add(Restrictions.eq("projectteacher", a));
        if((a=applicant.getStudentid())!=null) c.add(Restrictions.eq("studentid", a));
        if((d=applicant.getEnddate())!=null) c.add(Restrictions.eq("enddate", d));
        if((d=applicant.getStartdate())!=null) c.add(Restrictions.eq("startdate", d));
        if((i=applicant.getSalary())!=-1) c.add(Restrictions.eq("salary", i));
        list = c.list();
        return list;
    }


    public void delete(String id)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Applicant applicant;

        applicant = (Applicant) session.load(Applicant.class, id);
        session.delete(applicant);
        tx.commit();
    }
    public void modify(String id, Applicant newapplicant)
    {

        Session session = mysessionfactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Applicant applicant;
        applicant = (Applicant) session.load(Applicant.class, id);
        applicant.setApplyreason(newapplicant.getApplyreason());
        applicant.setCompanyaddress(newapplicant.getCompanyaddress());
        applicant.setCompanyconnectpeople(newapplicant.getCompanyconnectpeople());
        applicant.setCompanyconnectpeoplejob(newapplicant.getCompanyconnectpeoplejob());
        applicant.setCompanynaMe(newapplicant.getCompanynaMe());
        applicant.setEnddate(newapplicant.getEnddate());
        applicant.setHelpteacher(newapplicant.getHelpteacher());
        applicant.setJobgetway(newapplicant.getJobgetway());

        applicant.setProjectteacher(newapplicant.getProjectteacher());

        applicant.setSalary(newapplicant.getSalary());
        applicant.setStudentid(newapplicant.getStudentid());
        applicant.setStartdate(newapplicant.getStartdate());
        tx.commit();
    }
    public void add(Applicant applicant)
    {

        Session session = mysessionfactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(applicant);
        tx.commit();
    }
}
