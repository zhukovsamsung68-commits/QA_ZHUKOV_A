package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tasks.ComparatorInt;

public class ComparatorIntTest {

    @Test
    public void t1() {
        Assert.assertEquals(ComparatorInt.compare(5, 5), 0);
    }

    @Test
    public void t2() {
        Assert.assertTrue(ComparatorInt.compare(3, 5) < 0);
    }

    @Test
    public void t3() {
        Assert.assertTrue(ComparatorInt.compare(7, 2) > 0);
    }
}
