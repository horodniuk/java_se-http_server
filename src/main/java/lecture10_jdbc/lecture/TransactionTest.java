package lecture10_jdbc.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    public static void main(String[] args) throws SQLException {
       /* try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234")) {
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from students where id=?")) {
                preparedStatement.setLong(1, 20);
                int deleted = preparedStatement.executeUpdate();
                System.out.println("Deleted " + deleted + " row");
            }
            connection.commit();  // only after commit data send to dataBase
        }*/
    }
}
