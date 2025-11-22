package tasks;

public class Factorial {
    public static long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException();
        long r = 1;
        for (int i = 1; i <= n; i++) r *= i;
        return r;
    }
}
