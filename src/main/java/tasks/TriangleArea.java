package tasks;

public class TriangleArea {
    public static double calculate(double base, double height) {
        if (base <= 0 || height <= 0) throw new IllegalArgumentException();
        return 0.5 * base * height;
    }
}
