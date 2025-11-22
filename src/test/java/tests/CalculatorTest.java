package tests;

import org.junit.jupiter.api.Test;
import tasks.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void t1() {
        assertEquals(7, Calculator.add(3, 4));
    }

    @Test
    void t2() {
        assertEquals(1, Calculator.subtract(5, 4));
    }

    @Test
    void t3() {
        assertEquals(20, Calculator.multiply(4, 5));
    }

    @Test
    void t4() {
        assertEquals(2.5, Calculator.divide(5, 2));
    }

    @Test
    void t5() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }
}
