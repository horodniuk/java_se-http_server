package lecture11_unit_test_mockito.lecture2.users_program.dao;

import lombok.SneakyThrows;

import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {
    @SneakyThrows
    public boolean delete (Integer userId) throws SQLException {
        try(var connection = DriverManager.getConnection("url", "username", "password")) {
            return true;
        }

    }
}
