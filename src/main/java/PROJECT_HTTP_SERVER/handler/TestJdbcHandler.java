package PROJECT_HTTP_SERVER.handler;

import PROJECT_HTTP_SERVER.HttpHandler;
import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.HttpResponse;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.entity.Student;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;
import PROJECT_HTTP_SERVER.utils.DataUtils;
import PROJECT_HTTP_SERVER.utils.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestJdbcHandler implements HttpHandler {
    @Override
    public void handle(HttpServerContext  context, HttpRequest request, HttpResponse response) throws IOException {
        try (Connection c = context.getDataSource().getConnection()) {
            List<Student> list = JDBCUtils.select(c, "select * from student", STUDENTS_RESULT_SET_HANDLER);
            Map<String, Object> args = DataUtils.buildMap(new Object[][] {
                    { "TABLE-BODY", getTableBody(context, list) }
            });
            response.setBody(context.getHtmlTemplateManager().processTemplate("students.html", args));
        } catch (SQLException e) {
            throw new HttpServerException("Error with database: " + e.getMessage(), e);
        }
    }

    protected String getTableBody(HttpServerContext context, List<Student> list) {
        StringBuilder body = new StringBuilder();
        for (Student s : list) {
            Map<String, Object> args = DataUtils.buildMap(new Object[][] {
                    { "ID", s.getId() },
                    { "FIRST-NAME", s.getFirstName() },
                    { "LAST-NAME", s.getLastName() },
                    { "AGE", s.getAge() }
            });
            String fragment = context.getHtmlTemplateManager().processTemplate("student-row.html", args);
            body.append(fragment);
        }
        return body.toString();
    }

    private static ResultSetHandler<List<Student>> STUDENTS_RESULT_SET_HANDLER = rs -> {
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Student(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("age")));
        }
        return list;
    };
}
