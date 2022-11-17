package lecture9_multithreading.hometask.download_images;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DownloadTask implements Runnable {
    private String link;
    private Path targetDir;
    private ExecutorService executorService;
    private int tryCount;

    public DownloadTask(String link, Path targetDir, ExecutorService executorService, int tryCount) {
        this.link = link;
        this.targetDir = targetDir;
        this.executorService = executorService;
        this.tryCount = tryCount;
    }

    @Override
    public void run() {
        String fileName = String.format("/image_%s.jpg", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss.SSS")));
        try (InputStream in = new URL(link).openStream()) {
            Files.copy(in, Paths.get(new File(targetDir.toFile(), fileName).getAbsolutePath()));
            System.out.println("Link downloaded: " + link);
        } catch (IOException e) {
            e.printStackTrace();
            tryCount--;
            if (tryCount > 0) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e1) {
                    return;
                }

                executorService.submit(this);
            } else {
                System.err.println("Image not downloaded: " + link);
            }
        }
    }
}
