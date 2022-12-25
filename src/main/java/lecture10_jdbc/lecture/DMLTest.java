package lecture10_jdbc.lecture;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DMLTest {
    @SneakyThrows
    public static void main(String[] args) {
       /*  try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234")) {
           try (PreparedStatement preparedStatement = connection.prepareStatement("insert into students values(?,?,?,?)")) {
                preparedStatement.setLong(1, 20);
                preparedStatement.setString(2, "Jack");
                preparedStatement.setString(3, "Sparrow");
                preparedStatement.setInt(4, 25);
                int inserted = preparedStatement.executeUpdate();
                System.out.println("Inserted " + inserted + " row");
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "update students set firstname=?, lastname=?, age=? where id=?")) {
                preparedStatement.setString(1, "Bob");
                preparedStatement.setString(2, "Smith");
                preparedStatement.setInt(3, 18);
                preparedStatement.setLong(4, 0);
                int updated = preparedStatement.executeUpdate();
                System.out.println("Updated " + updated + " row");
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?")) {
                preparedStatement.setLong(1, 20);
                int deleted = preparedStatement.executeUpdate();
                System.out.println("Deleted " + deleted + " row");
            }
        }*/
    }
}
