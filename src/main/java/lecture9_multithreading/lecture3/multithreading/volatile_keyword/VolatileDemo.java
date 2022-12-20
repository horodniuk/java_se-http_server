package lecture9_multithreading.lecture3.multithreading.volatile_keyword;

public class VolatileDemo {
    private static boolean flag;
    public static void main(String[] args) throws InterruptedException {
        String s;
        Thread thread_1 = new Thread(
                ()->{
                    while (!flag){
                        System.out.println("stell false");
                    }
                }
        );
        thread_1.start();

        Thread.sleep(5L);

        Thread thread_2 = new Thread(
                ()-> {
                    flag = true;
                    System.out.println("flag is true");
                }
        );
        thread_2.start();
    }


}
