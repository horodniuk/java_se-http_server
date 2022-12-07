package lecture11_unit_test_mockito.lecture2.users_program.dao;

import org.mockito.stubbing.Answer1;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class USerDaoSpy extends UserDao {
    private UserDao userDao;
    private Map<Integer, Boolean> answers = new HashMap<>();
    private Answer1<Integer, Boolean> answer1;
    @Override
    public boolean delete (Integer userId) throws SQLException {
        return answers.getOrDefault(userId, userDao.delete(userId));
    }
}
