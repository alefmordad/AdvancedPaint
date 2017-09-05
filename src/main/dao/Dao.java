package main.dao;

import main.model.Model;
import main.utils.DaoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class Dao<T extends Model> {

    protected Configuration configuration;
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;
    protected Class aClass;

    {
        configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    protected Dao(Class aClass) {
        this.aClass = aClass;
    }

    public void create(T t) throws DaoException {
        transaction = session.beginTransaction();
        try {
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException();
        }
    }

    public abstract T get(T t) throws DaoException;

    @Override
    protected void finalize() throws Throwable {
        session.close();
        sessionFactory.close();
        super.finalize();
    }

}
