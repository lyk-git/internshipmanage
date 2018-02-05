package daoimp;

import dao.RecruitmentDao;
import model.Recruitment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RecruitmentDaoImp implements RecruitmentDao {

    public static SessionFactory mysessionfactory;

    public static void setMysessionfactory(SessionFactory mysessionfactory) {
        StudentDaoImp.mysessionfactory = mysessionfactory;
    }

    public List query()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        List list;
        Criteria c = session.createCriteria(Recruitment.class);
        list = c.list();
        return list;
    }
    public List query(Recruitment recruitment)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Recruitment recruitment;

        recruitment = session.load(Recruitment.class, id);
        session.delete(recruitment);
        tx.commit();
    }
    public void modify(String id,Recruitment newrecruitment)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Recruitment recruitment;
        recruitment =  session.load(Recruitment.class, id);
        recruitment.setContent(newrecruitment.getContent());
        recruitment.setPublisher(newrecruitment.getPublisher());
        tx.commit();
    }
    public void add(Recruitment recruitment)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("model/spring-hibernate.xml");

        Session session = mysessionfactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(recruitment);
        tx.commit();
    }
}
