package lecture11_unit_test_mockito.lecture2;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkUtilsTest {
    @Test (timeout = 2000)
    public void getConnectionShouldReturnThanOneSecond(){
        NetworkUtils.getConnection();
    }
}