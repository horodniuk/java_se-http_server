package PROJECT_HTTP_SERVER;

import java.util.List;

public class Constants {
    public static final String HTTP_VERSION = "HTTP/1.1";
    public  static final String GET = "GET";
    public  static final String POST = "POST";
    public  static final String HEAD = "HEAD";

    public static final List <String> ALLOWED_METHODS = List.of(GET, POST, HEAD);

    private Constants() {
    }
}
