package lecture9_multithreading.hometask.download_images;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DownloadImageExecutor {
    private int threadCount;
    private int tryCount;
    private Path targetDir;

    public DownloadImageExecutor(int threadCount, int tryCount, Path targetDir) {
        this.threadCount = threadCount;
        this.tryCount = tryCount;
        this.targetDir = targetDir;
    }

  /*  public void launcher() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<String> links = Files.readAllLines(Paths.get("resources/files_for_multithread_module/source/index.txt"), StandardCharsets.UTF_8);
        for(String link : links) {
            executorService.submit(new DownloadTask(link, targetDir, executorService, tryCount));
        }
        executorService.shutdown();
    }*/

 /*   public static String readStringFromURL(String requestURL) throws IOException {
        List<String> arrayList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
                StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            arrayList.add(scanner.nextLine());
            return scanner.hasNextLine() ? scanner.nextLine() : "";
        }
    }*/
}
