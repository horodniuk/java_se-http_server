package lecture10_jdbc.lecture;

import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionTest {
    public static void main(String[] args) throws SQLException {
       /* try (Connection c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres", "1234")) {
            System.out.println(c.isValid(0));
        }*/

        //  2 variant-----------------------------------------------
        DataSource ds = createPostgresqlDataSource();
        try {
            try(Connection c = ds.getConnection()){
                System.out.println(c.isValid(0));
            }
        } finally {
            ((PGPoolingDataSource)ds).close();
        }
    }

    private static DataSource createPostgresqlDataSource(){
        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setDataSourceName("A Data Source");
        ds.setServerName("localhost");
        ds.setDatabaseName("student");
        ds.setUser("postgres");
        ds.setPassword("1234");
        ds.setInitialConnections(1);
        ds.setMaxConnections(3);
        return ds;
    }

}
