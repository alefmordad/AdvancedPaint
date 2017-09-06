package dao;

import main.dao.UserDao;
import main.model.User;
import main.utils.utils.exceptions.DaoException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestUserDao {

    UserDao userDao = new UserDao();
    User user = new User("test", "test");

    @Test
    public void addUser() throws DaoException {
        List<User> all = userDao.getAll();
        userDao.create(user);
        List<User> newAll = userDao.getAll();
        userDao.delete(user);
        assertEquals(newAll.size(), all.size() + 1);
    }

}
