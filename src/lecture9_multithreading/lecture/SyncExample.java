package lecture9_multithreading.lecture;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SyncExample {
    private List<String> list = new LinkedList<String>();
    private int count = 0;

    public void addString(String s){
        count++;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        list.add(s);
    }

    public String getString() {
        if(count > 0) {
            count--;
            return list.remove(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
