package PROJECT_HTTP_SERVER.utils;



import PROJECT_HTTP_SERVER.handler.ResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
    public static <T> T select(Connection c, String sql, ResultSetHandler<T> resultSetHandler, Object... parameters)
            throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            populatePreparedStatement(ps, parameters);
            try (ResultSet rs = ps.executeQuery()) {
                return resultSetHandler.handle(rs);
            }
        }
    }

    private static void populatePreparedStatement(PreparedStatement ps, Object... parameters) throws SQLException {
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
        }
    }
}
