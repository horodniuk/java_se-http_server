package lecture10_jdbc.lecture;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class BatchOperations {

    @SneakyThrows
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres",
                "1234")) {
            try (PreparedStatement ps = c.prepareStatement("insert into students values(?,?,?,?)")) {
                for (int i = 0; i < 20; i++) {
                    ps.setLong(1, 100 + i);
                    ps.setString(2, "Jack" + i);
                    ps.setString(3, "Sparrow" + i);
                    ps.setInt(4, new Random().nextInt(10) + 18);
                    ps.addBatch();
                }
                int[] inserted = ps.executeBatch();
                System.out.println("Inserted " + Arrays.toString(inserted) + " rows");
            }
        }
    }
}
