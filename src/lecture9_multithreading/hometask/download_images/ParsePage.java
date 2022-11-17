package lecture9_multithreading.hometask.download_images;

import java.io.*;
import java.net.URL;

public class ParsePage {

    public static void main(String[] args) {
        String url = "https://github.com/devstudy-net/home-tasks/blob/master/files/links/images.txt";
        try {
            downloadUsingStream(url, "resources/files_for_multithread_module/temp/images.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

}
