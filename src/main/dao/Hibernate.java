package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private final static SessionFactory sessionFactory;
    private final static Session session;

    static {
        {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
        }
    }

    public static Session getSession() {
        return session;
    }
}
