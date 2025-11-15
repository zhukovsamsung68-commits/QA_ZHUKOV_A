public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Массив должен иметь размер 4x4");
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
