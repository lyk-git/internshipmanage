package daoimp;

import dao.ApplicantDao;
import model.Applicant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.List;

public class ApplicantDaoImp implements ApplicantDao {

    public static SessionFactory mysessionfactory;

    public static void setMysessionfactory(SessionFactory mysessionfactory) {
        StudentDaoImp.mysessionfactory = mysessionfactory;
    }

    public List query()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        List list;
        Criteria c = session.createCriteria(Applicant.class);
        list = c.list();
        return list;
    }
    public List query(Applicant applicant)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Applicant applicant;

        applicant = (Applicant) session.load(Applicant.class, id);
        session.delete(applicant);
        tx.commit();
    }
    public void modify(String id,Applicant newapplicant)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();

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
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(applicant);
        tx.commit();
    }
}
