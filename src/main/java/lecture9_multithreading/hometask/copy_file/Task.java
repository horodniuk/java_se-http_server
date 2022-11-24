package lecture9_multithreading.hometask.copy_file;

public interface Task {
    void start() throws InterruptedException;
    void interrupt();
    int getPersentProcesses();
}
