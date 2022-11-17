package lecture9_multithreading.hometask.download_images;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        DownloadImageExecutor e = new DownloadImageExecutor(10, 3, Paths.get(
                "resources/files_for_multithread_module/images/"));
        try {
            e.launcher();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
