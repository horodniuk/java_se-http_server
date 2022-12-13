package lecture10_jdbc.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class JDBCUtilsTest {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234")) {
            Map<String, Object> map = JDBCUtils.select(connection, "select * from students",
                    resultSet -> {
                        if (resultSet.next()) {
                            Map<String, Object> map1 = new LinkedHashMap<>();
                            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                                map1.put(resultSet.getMetaData().getColumnLabel(i), resultSet.getObject(i));
                            }
                            return map1;
                        } else {
                            return Collections.emptyMap();
                        }
                    });
            System.out.println(map);
        }

    }
}
