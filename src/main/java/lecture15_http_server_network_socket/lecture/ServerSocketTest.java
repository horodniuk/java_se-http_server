package lecture15_http_server_network_socket.lecture;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9090);
             Socket socket = serverSocket.accept();
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
                String message = "It is simple http server";
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.println("Content-Type: text/html");
                printWriter.println("Content-Length: " + message.length());
                printWriter.println("Connection: close");
                printWriter.println();
                printWriter.println(message);
        }
        System.out.println("Completed");
    }
}
