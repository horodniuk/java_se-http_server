package lecture9_multithreading.hometask.copy_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFileTaskThread implements Task, Runnable {
    private Path sourcePath;
    private Path destinationPath;
    private long sourseSize;
    private Thread thread;
    private volatile long percentCopy;

    public CopyFileTaskThread(Path sourcePath, Path destinationPath) throws IOException {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.sourseSize = Files.size(sourcePath);
        this.thread = new Thread(this, "CopyFileTaskThread");
        this.percentCopy = 0;
    }

    @Override
    public void start() throws InterruptedException {
        if (thread.getState() != Thread.State.NEW){
            throw new IllegalArgumentException("Copy file already execution");
        } else {
            thread.start();
        }
    }

    @Override
    public void interrupt() {
            this.thread.interrupt();
    }

    @Override
    public int getPersentProcesses() {
        return (int) (this.percentCopy * 100 / sourseSize);
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
                percentCopy += read;
            }

        } catch (IOException e) {
            System.err.println("Copy failed :" + e.getMessage());
            e.printStackTrace();
        }
    }
}

