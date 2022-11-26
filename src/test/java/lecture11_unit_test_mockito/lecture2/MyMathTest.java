package lecture11_unit_test_mockito.lecture2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {
        @Test(expected = ArithmeticException.class)
        public void zeroDenominatorShouldThrowException(){
            MyMath.divide(1, 0);
        }
}