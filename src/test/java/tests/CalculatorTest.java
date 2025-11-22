package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.Calculator;

public class CalculatorTest {

    @Test
    public void t1() {
        Assert.assertEquals(Calculator.add(3, 4), 7);
    }

    @Test
    public void t2() {
        Assert.assertEquals(Calculator.subtract(5, 4), 1);
    }

    @Test
    public void t3() {
        Assert.assertEquals(Calculator.multiply(4, 5), 20);
    }

    @Test
    public void t4() {
        Assert.assertEquals(Calculator.divide(5, 2), 2.5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void t5() {
        Calculator.divide(5, 0);
    }
}
