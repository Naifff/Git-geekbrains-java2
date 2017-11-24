package ru.geekbrains.java2.dz.dz2.NikitaKremlev;

public class Main {

    public static int lengthOfArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4)
            throw new MyArraySizeException();
        if (array[0].length != 4)
            throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (checkString(array[i][j])) {
                    sum += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException("Не удалось преобразовать ячейку в позиции: [" + i + "; " + j + "], значение \"" + array[i][j] + "\";");
                }
            }

        }
        return sum;
    }

    /**
     * Проверяет является ли строка числом
     * @param string проверяемая строка
     * @return boolean значение, если строка число то true
     */
    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int sumOne = 0, sumTwo = 0, sumThree = 0;
        // Массив один
        String[][] arrayOne = new String[4][4];
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayOne[i].length; j++) {
                arrayOne[i][j] = "" + i * j + "";
            }
        }
        // Массив два
        String[][] arrayTwo = new String[4][4];
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[i].length; j++) {
                arrayTwo[i][j] = "" + i * j + "";
            }
        }
        arrayTwo[1][1] = "вася";
        // Массив три
        String[][] arrayThree = new String[4][3];
        try {
            sumOne = Main.lengthOfArray(arrayOne); // Работает
            //sumTwo = Main.lengthOfArray(arrayTwo); // MyArrayDataException
            //sumThree = Main.lengthOfArray(arrayThree); // MyArraySizeException
            System.out.println(sumOne + ", " + sumTwo + ", " + sumThree + ";");
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}
