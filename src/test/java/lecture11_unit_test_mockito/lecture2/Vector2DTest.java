package lecture11_unit_test_mockito.lecture2;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private final double EPS = 1e-9;
    private Vector2D v;

    @Before
    public void createNewVector(){
        v = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLenght(){
        Assert.assertEquals(0, v.lenghtVector(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroX(){
        Assert.assertEquals(0, v.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY(){
        Assert.assertEquals(0, v.getY(), EPS);
    }
}