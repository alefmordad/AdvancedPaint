package main.dao;

import main.model.Model;
import main.model.User;
import main.utils.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class Dao<T extends Model> {

    private final SessionFactory sessionFactory;
    final Session session;
    Transaction transaction;
    Class aClass;
    private User user;

    {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    Dao(Class aClass) {
        this.aClass = aClass;
    }

    Dao(Class aClass, User user) {
        this.aClass = aClass;
        this.user = user;
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

    public List<T> getAll() throws DaoException {
        transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(aClass);
            criteria.add(Restrictions.eq("user", user));
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException();
        } finally {
            transaction.commit();
        }
    }

    public void clear() throws DaoException {
        transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(aClass);
            criteria.add(Restrictions.eq("user", user));
            for (Object t : criteria.list())
                session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        session.close();
        sessionFactory.close();
        super.finalize();
    }

}
