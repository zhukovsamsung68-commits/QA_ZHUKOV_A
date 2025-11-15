public class MyArrayDataException extends Exception {
    public MyArrayDataException() {
        super("Ошибка данных в массиве");
    }

    public MyArrayDataException(String message) {
        super(message);
    }
}
