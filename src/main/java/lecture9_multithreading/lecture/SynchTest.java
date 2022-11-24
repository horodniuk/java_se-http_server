package lecture9_multithreading.lecture;

public class SynchTest {
    public synchronized void syncMethod() {
    }
    public void syncBlock() {
        synchronized (this) {
        }
    }
    public synchronized static void staticSyncMethod() {
    }
    public static void staticSyncBlock() {
        synchronized (SynchTest.class) {
        }
    }

}
