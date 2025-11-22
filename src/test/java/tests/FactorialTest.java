package tests;

import org.junit.jupiter.api.Test;
import tasks.Factorial;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    void t1() {
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    void t2() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    void t3() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}
