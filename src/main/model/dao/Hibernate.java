package main.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private final static SessionFactory sessionFactory;
    private final static Session session;

    static {
        {
            Configuration cfg = new Configuration();
            cfg.configure();
            sessionFactory = cfg.buildSessionFactory();
            session = sessionFactory.openSession();
        }
    }

    public static Session getSession() {
        return session;
    }
}
