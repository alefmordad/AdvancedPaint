package main.dao;

import main.model.User;
import main.utils.DaoException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao extends Dao<User> {

    public UserDao() {
        super(User.class);
    }

    public User get(User user) throws DaoException {
        transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(aClass);
            criteria.add(Restrictions.eq("username", user.getUsername()));
            criteria.setMaxResults(1);
            List list = criteria.list();
            return (User) list.get(0);
        } catch (Exception h) {
            throw new DaoException();
        } finally {
            transaction.commit();
        }
    }
}
