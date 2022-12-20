package lecture9_multithreading.lecture3.multithreading.deadlock;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account(20000);
        Account a2 = new Account(20000);

        AccountThread accountThread1 = new AccountThread(a1, a2);
        AccountThread accountThread2 = new AccountThread(a2, a1);

        accountThread1.start();
        accountThread2.start();

        accountThread1.join();
        accountThread2.join();

        System.out.println(a1);
        System.out.println(a2);

    }
}
