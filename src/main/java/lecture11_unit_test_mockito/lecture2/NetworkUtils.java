package lecture11_unit_test_mockito.lecture2;

public class NetworkUtils {
    public static void getConnection(){
        // get connection server
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}
