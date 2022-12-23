package lecture9_multithreading.lecture3.concurrent.pool;

import java.util.Optional;
import java.util.Queue;

public class PoolThread extends Thread {
    private  Queue<Runnable> tasks;

    public PoolThread(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true){
            Optional<Runnable> task = Optional.empty();  // пока нету задач
            synchronized (tasks){
                if (!tasks.isEmpty()){  // если задача которую мы должны решить
                    task = Optional.of(tasks.remove());
                }
            }
            task.ifPresent(Runnable::run);
        }
    }
}
