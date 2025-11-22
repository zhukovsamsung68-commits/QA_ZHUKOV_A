package tests;

import org.junit.jupiter.api.Test;
import tasks.TriangleArea;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {
    @Test
    void t1() {
        assertEquals(10.0, TriangleArea.calculate(4, 5));
    }

    @Test
    void t2() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculate(-1, 5));
    }
}
