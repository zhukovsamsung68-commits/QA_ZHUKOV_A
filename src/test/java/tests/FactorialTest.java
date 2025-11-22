package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.Factorial;

public class FactorialTest {

    @Test
    public void t1() {
        Assert.assertEquals(Factorial.calculate(5), 120);
    }

    @Test
    public void t2() {
        Assert.assertEquals(Factorial.calculate(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void t3() {
        Factorial.calculate(-1);
    }
}
