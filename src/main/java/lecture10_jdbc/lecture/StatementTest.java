package lecture10_jdbc.lecture;

import lombok.SneakyThrows;

import java.sql.*;

public class StatementTest {
    @SneakyThrows
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234")){

            try(Statement statement = connection.createStatement()){
                int result = statement.executeUpdate("delete from students where id=100");
                System.out.println("deleted " + result + " row(s)");
            }

            try(PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?")) {
                preparedStatement.setInt(1, 100);
                int result = preparedStatement.executeUpdate();
                System.out.println("deleted " + result + " row(s)");
            }

            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from students")) {
                }
            }
        }
    }
}
