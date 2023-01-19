package lecture12_logging.lecture;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
