package lecture16_http_interface;

import java.io.InputStream;
import java.io.Reader;
/**
 * Этот компонент будет предоставлять информацию ответа
 */
public interface HttpResponse {
    void setStatus(int status); // статус ответа

    void setHeader(String name, Object value); // header ответа

    void setBody(String content); // body ответа

    void setBody(InputStream in);

    void setBody(Reader reaser);

}
