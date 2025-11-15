public class Main {

    // Метод проверки массива
    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        // Проверка размера
        if (arr.length != 4) {
            throw new MyArraySizeException("Неверное количество строк. Требуется 4.");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в строке " + i + ". Требуется 4.");
            }
        }

        int sum = 0;

        // Проходим по массиву
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Ошибка преобразования в ячейке [" + i + "][" + j + "]: значение = " + arr[i][j]
                    );
                }
            }
        }

        return sum;
    }

    // Вызов метода и обработка исключений
    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] badDataArray = {
                {"1", "2", "x", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(correctArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("---- Проверка второго массива ----");

        try {
            int result = processArray(badDataArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
