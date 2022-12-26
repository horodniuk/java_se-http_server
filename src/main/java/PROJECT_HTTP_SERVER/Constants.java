package PROJECT_HTTP_SERVER;

import java.util.List;

public class Constants {
    public static final String HTTP_VERSION = "HTTP/1.1";
    public  static final String GET = "Get";
    public  static final String POST = "Post";
    public  static final String HEAD = "Head";

    public static final List <String> ALLOWED_METHODS = List.of(GET, POST, HEAD);

    private Constants() {
    }
}
