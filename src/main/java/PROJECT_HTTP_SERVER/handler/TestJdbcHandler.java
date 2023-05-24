package PROJECT_HTTP_SERVER.handler;

import PROJECT_HTTP_SERVER.HttpHandler;
import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.HttpResponse;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbcHandler implements HttpHandler {
    @Override
    public void handle(HttpServerContext  context, HttpRequest request, HttpResponse response) throws IOException {
        try(Connection c = context.getDataSource().getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from student")) {
            if(rs.next()) {
                response.setBody(rs.getString(1));
            } else {
                response.setBody("null");
            }
        } catch (SQLException e) {
            throw new HttpServerException("Error with database: " + e.getMessage(), e);
        }
    }
}
