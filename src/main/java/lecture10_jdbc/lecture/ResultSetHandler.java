package lecture10_jdbc.lecture;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler<T> {
    @SneakyThrows
    T handle(ResultSet rs) throws SQLException;
}
