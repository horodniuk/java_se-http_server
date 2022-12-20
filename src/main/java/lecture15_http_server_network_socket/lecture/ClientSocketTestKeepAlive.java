package lecture15_http_server_network_socket.lecture;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ClientSocketTestKeepAlive {
    private static final String CONTENT_LENGTH = "content-length: ";

    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Socket socket = new Socket("stackoverflow.com", 80);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             InputStream inputStream = socket.getInputStream()) {
            for (String s : Arrays.asList("GET / HTTP/1.1", "Host: stackoverflow.com", "Connection: keep-alive")) {
                printWriter.println(s);
            }
            printWriter.println();
            ByteArray byteArray = new ByteArray();
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    return;
                }
                byteArray.add((byte) read);
                if (byteArray.isEmptyLine()) {
                    break;
                }
            }
            String header = new String(byteArray.toArray(), StandardCharsets.UTF_8);
            StringBuilder httpResponse = new StringBuilder(header);
            int contentLengthIndex = header.toLowerCase().indexOf(CONTENT_LENGTH);
            if (contentLengthIndex != -1) {
                int startCutIndex = contentLengthIndex + CONTENT_LENGTH.length();
                int endCutIndex = header.indexOf("\r\n", startCutIndex);
                int contentLength = Integer.parseInt(header.substring(startCutIndex, endCutIndex).trim());
                while (contentLength > 0) {
                    byte[] messageBody = new byte[contentLength];
                    int read = inputStream.read(messageBody);
                    httpResponse.append(new String(messageBody, 0, read, StandardCharsets.UTF_8));
                    contentLength -= read;
                }
            }
            System.out.println(httpResponse);
        }
    }

    private static class ByteArray {
        private byte[] array = new byte[1024];
        private int size;

        public void add(byte value) {
            if (size == array.length) {
                byte[] temp = array;
                array = new byte[array.length * 2];
                System.arraycopy(temp, 0, array, 0, size);
            }
            array[size++] = value;
        }

        public byte[] toArray() {
            return Arrays.copyOf(array, size);
        }

        public boolean isEmptyLine() {
            if (size >= 4) {
                return array[size - 1] == '\n' && array[size - 2] == '\r'
                       && array[size - 3] == '\n' && array[size - 4] == '\r';
            } else {
                return false;
            }
        }
    }
}
