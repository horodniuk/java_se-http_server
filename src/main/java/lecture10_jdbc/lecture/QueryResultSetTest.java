package lecture10_jdbc.lecture;

import java.sql.*;

public class QueryResultSetTest {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234")) {
            try (Statement st = connection.createStatement()) {
                try (ResultSet resultSet = st.executeQuery("select * from students")) {
                    ResultSetMetaData meta = resultSet.getMetaData();
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        display(meta.getColumnLabel(i));
                        if (i != meta.getColumnCount()) {
                            System.out.print("| ");
                        }
                    }
                    System.out.println("\n---------------------------------------");
                    while (resultSet.next()) {
                        for (int i = 1; i <= meta.getColumnCount(); i++) {
                            display(String.valueOf(resultSet.getObject(i)));
                            if (i != meta.getColumnCount()) {
                                System.out.print("| ");
                            }
                        }
                        System.out.println("\n---------------------------------------");
                    }
                }
            }
        }
    }

    private static void display(String value) {
        System.out.print(value);
        for (int i = 0; i < 10 - value.length(); i++) {
            System.out.print(" ");
        }
    }

}
