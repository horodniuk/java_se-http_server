package lecture15_http_server_network_socket.lecture;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketTest {
    public static void main(String[] args) {
        try(Socket socket = new Socket("www.wikipedia.org", 80);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true); // что бы записать данные
            InputStream inputStream = socket.getInputStream()) {  // для того чтобы считать данные из сокета
            ClientSSLSocketTest.getWebData(printWriter, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
