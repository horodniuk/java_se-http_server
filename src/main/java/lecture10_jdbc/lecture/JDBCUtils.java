package lecture10_jdbc.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
   /* public static <T> T select(Connection connection, String sql, ResultSetHandler<T> resultSetHandler, Object... parameters)
            throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            populatePreparedStatement(preparedStatement, parameters);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSetHandler.handle(resultSet);
            }
        }
    }
    public static <T> T insert(Connection connection, String sql, ResultSetHandler<T> resultSetHandler, Object... parameters)
            throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            populatePreparedStatement(preparedStatement, parameters);
            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                throw new SQLException("Can't insert row to database. Result=" + result);
            }
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                return resultSetHandler.handle(resultSet);
            }
        }
    }
    private static void populatePreparedStatement(PreparedStatement ps, Object... parameters) throws SQLException {
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
        }
    }*/
}
