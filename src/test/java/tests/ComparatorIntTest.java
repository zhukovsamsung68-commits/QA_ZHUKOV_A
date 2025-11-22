package tests;

import org.junit.jupiter.api.Test;
import tasks.ComparatorInt;
import static org.junit.jupiter.api.Assertions.*;

public class ComparatorIntTest {
    @Test
    void t1() {
        assertEquals(0, ComparatorInt.compare(5, 5));
    }

    @Test
    void t2() {
        assertTrue(ComparatorInt.compare(3, 5) < 0);
    }

    @Test
    void t3() {
        assertTrue(ComparatorInt.compare(6, 2) > 0);
    }
}
