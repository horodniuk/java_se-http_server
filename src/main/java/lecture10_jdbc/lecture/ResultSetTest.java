package lecture10_jdbc.lecture;

import lombok.SneakyThrows;

import java.sql.*;

public class ResultSetTest {
    @SneakyThrows
    public static void main(String[] args) {
      /*  try(Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student",
                "postgres", "1234")){

            try(Statement statement = connection.createStatement()){
               try (ResultSet resultSet = statement.executeQuery("select * from students")){
                   while (resultSet.next()){
                       System.out.println( resultSet.getLong(1)+", "
                                          +resultSet.getString(2)+", "
                                          +resultSet.getString(3)+", "
                                          +resultSet.getInt(4));
                   }

                   System.out.println("___________________");
                 *//*  try(ResultSet rs = statement.executeQuery("select * from students")) {
                       while(rs.next()){
                           System.out.println(resultSet.getLong("id")+", "
                                              +resultSet.getString("first_name")+", "
                                              +resultSet.getString("last_name")+", "
                                              +resultSet.getInt("age"));
                       }
                   }*//*
               }
            }


        }*/
    }
}
