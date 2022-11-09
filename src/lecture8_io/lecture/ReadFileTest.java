package lecture8_io.lecture;

import java.io.*;

public class ReadFileTest {
    public static void main(String[] args) throws IOException {
        //readLines1();
        // readLines2();
        // readLines3();
        // readLines4();
        //   readLines5();
         readLines6();

    }

    private static void readLines1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/lecture8_io/text-file.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    private static void readLines2() throws IOException {
        StringWriter wr = new StringWriter();
        char[] cbuf = new char[8192];
        Reader r = new FileReader("src/lecture8_io/text-file.txt");
        while (true) {
            int read = r.read(cbuf);
            if (read == -1) {
                break;
            }
            wr.write(cbuf, 0, read);
        }
        System.out.println(wr.toString());
        r.close();
    }

    private static void readLines3() throws IOException {
        StringBuilder res = new StringBuilder();
        char[] cbuf = new char[8192];
        Reader r = new FileReader("src/lecture8_io/text-file.txt");
        while (true) {
            int read = r.read(cbuf);
            if (read == -1) {
                break;
            }
            res.append(new String(cbuf, 0, read));
        }
        System.out.println(res.toString());
        r.close();
    }

    private static void readLines4() throws IOException {
        StringBuilder res = new StringBuilder();
        Reader r = new FileReader("src/lecture8_io/text-file.txt");
        while (true) {
            int symbol = r.read();
            if (symbol == -1) {
                break;
            }
            res.append((char) symbol);
        }
        System.out.println(res.toString());
        r.close();
    }

    private static void readLines5() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("text-file.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readLines6() {
    }



}
