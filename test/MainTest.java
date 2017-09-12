import main.controller.utils.Hash;
import main.controller.utils.utils.exceptions.DaoException;
import main.model.User;
import main.model.dao.UserDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void addUser() throws DaoException {
        UserDao userDao = new UserDao();
        User user = new User("test", "test");
        List<User> all = userDao.getAll();
        userDao.create(user);
        List<User> newAll = userDao.getAll();
        userDao.delete(user);
        assertEquals(newAll.size(), all.size() + 1);
    }

    @Test
    public void getMD5() {
        String str = "test";
        String str2 = "test";
        assertEquals(Hash.getMD5String(str), Hash.getMD5String(str2));
    }

}
