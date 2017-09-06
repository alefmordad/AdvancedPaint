package main.dao;

import main.model.Model;
import main.model.User;
import main.utils.utils.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class Dao<T extends Model> {

    protected Session session = Hibernate.getSession();
    Transaction transaction;
    Class aClass;
    private User user;


    Dao(Class aClass) {
        this.aClass = aClass;
    }

    Dao(Class aClass, User user) {
        this.aClass = aClass;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
            return criteria.list();
        } catch (Exception e) {
            throw new DaoException();
        } finally {
            transaction.commit();
        }
    }

    public void clear() throws DaoException {
        transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(aClass);
            for (Object t : criteria.list())
                session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException();
        }
    }

    public void update(T t) throws DaoException {
        transaction = session.beginTransaction();
        try {
            session.update(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException();
        }
    }

    public void delete(T t) throws DaoException {
        transaction = session.beginTransaction();
        try {
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
        super.finalize();
    }

}
