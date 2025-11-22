package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.TriangleArea;

public class TriangleAreaTest {

    @Test
    public void t1() {
        Assert.assertEquals(TriangleArea.calculate(4, 5), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void t2() {
        TriangleArea.calculate(-1, 5);
    }
}
