package lecture15_http_server_network_socket.lecture;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ClientSSLSocketTest {
    public static void main(String[] args) {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) ssf.createSocket("www.wikipedia.org", 443);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             InputStream inputStream = socket.getInputStream()) {
             getWebData(printWriter, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getWebData(PrintWriter printWriter, InputStream inputStream) throws IOException {
        printWriter.println("GET / HTTP/1.1");
        printWriter.println("Host: www.wikipedia.org");
        printWriter.println("Connection: close");
        printWriter.println();
        StringBuilder html = new StringBuilder();
        byte[] bytes = new byte[1024];
        while (true) {
            int read = inputStream.read(bytes);
            if (read == -1) {
                break;
            }
            if (read > 0) {
                html.append(new String(bytes, 0, read, StandardCharsets.UTF_8));
            }
        }
        System.out.println(html);
    }
}
