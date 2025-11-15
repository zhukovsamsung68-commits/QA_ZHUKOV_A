public class Main {

    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        for (String[] row : arr) {
            if (row.length != 4) {
                throw new MyArraySizeException("Неверный размер массива");
            }
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String[][] correct = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] bad = {
                {"1", "2", "x", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма: " + processArray(correct));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма: " + processArray(bad));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
