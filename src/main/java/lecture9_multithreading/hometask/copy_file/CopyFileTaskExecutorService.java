package lecture9_multithreading.hometask.copy_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyFileTaskExecutorService implements Task, Runnable {
    private Path sourcePath;
    private Path destinationPath;
    private long sourseSize;
    private ExecutorService executorService;
    private volatile long poesentCopy;

    public CopyFileTaskExecutorService(Path sourcePath, Path destinationPath) throws IOException {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.sourseSize = Files.size(sourcePath);
        this.executorService = Executors.newSingleThreadExecutor();
        this.poesentCopy = 0;
    }

    @Override
    public void start() throws InterruptedException {
        if (executorService.isShutdown()){
            throw new IllegalArgumentException("Copy file already execution");
        } else {
            executorService.submit(this);
        }
    }

    @Override
    public void interrupt() {
            executorService.shutdownNow();
    }

    @Override
    public int getPersentProcesses() {
        return (int) (this.poesentCopy * 100 / sourseSize);
    }

    @Override
    public void run() {
        byte[] buffer = new byte[8000];
        try(InputStream in = new FileInputStream(sourcePath.toFile());
            OutputStream out = new FileOutputStream(destinationPath.toFile())
        ){
            while (!Thread.interrupted()){
                int read = in.read(buffer);
                if (read == -1){
                    break;
                }
                out.write(buffer, 0, read);
                poesentCopy += read;
            }

        } catch (IOException e) {
            System.err.println("Copy failed :" + e.getMessage());
            e.printStackTrace();
        }
    }
}

