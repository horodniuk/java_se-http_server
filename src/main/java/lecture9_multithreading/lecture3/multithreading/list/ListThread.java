package lecture9_multithreading.lecture3.multithreading.list;

import java.util.List;

public class ListThread extends Thread {
    private final List<Integer> list;

    public ListThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            System.out.println(Thread.currentThread().getName() + "->  add" + i);
            synchronized (list){
                list.add(i);
            }
        }
    }
}
