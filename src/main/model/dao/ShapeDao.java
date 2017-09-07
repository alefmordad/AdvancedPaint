package main.model.dao;

import main.model.User;
import main.model.model.shape.Shape;
import main.controller.utils.utils.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class ShapeDao extends Dao<Shape> {

    public ShapeDao(Class aClass, User user) {
        super(aClass, user);
    }

    public List<Shape> getAllFromUser() throws DaoException {
        transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(aClass);
            criteria.add(Restrictions.eq("user", getUser()));
            return criteria.list();
        } catch (Exception e) {
            throw new DaoException();
        } finally {
            transaction.commit();
        }
    }

    public void clearFromUser() throws DaoException {
        transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(aClass);
            criteria.add(Restrictions.eq("user", getUser()));
            for (Object t : criteria.list())
                session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DaoException();
        }
    }

}
