package ru.geekbrains.java2.dz.dz2.FedulovMS;

public class MainDZ2 {
    public static void main(String[] args) {
        //Простейшая матрица
        //String[][] matrix = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        //Матрица посложнее
        //String[][] matrix = {{"11", "-51", "100", "31"}, {"22", "16", "49", "-156"}, {"21", "104", "45", "17"}, {"8", "15", "46", "15"}};

        //Матрица не того размера
        //String[][] matrix = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        //Матрица с некорректным числом
        String[][] matrix = {{"1", "1", "1", "1"}, {"1", "1", "Q!", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            System.out.println(matrixSum(matrix));
        } catch (MyArraySizeException e) {
            //System.out.println(e);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            //System.out.println(e);
            e.printStackTrace();
        }
    }

    public static int matrixSum(String[][] matrix) throws MyArraySizeException, NumberFormatException {
        final int MATRIX_SIZE = 4;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean notSquare = false;
        int num = 0;
        int res = 0;
        int sgn;

        for (int i = 1; i < m; i++) {
             if (n != matrix[i].length) {
                 notSquare = true;
                 break;
             }
        }

        if (notSquare || m != MATRIX_SIZE || n != MATRIX_SIZE) {
            throw new MyArraySizeException("Ошибка размера массива: ожидается массив 4x4, получен массив "+m+"x"+n+".");
        }

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                num = 0;

                sgn = (matrix[i][j].charAt(0) == '-') ? -1 : 1;

                for (int k = (1-sgn)/2; k < matrix[i][j].length(); k++) {
                    if (matrix[i][j].charAt(k) >= '0' && matrix[i][j].charAt(k) <= '9'){
                        num = num*10 + sgn*(matrix[i][j].charAt(k) - '0');
                    } else {
                        throw new NumberFormatException("Не число в ячейке ("+i+", "+j+"): \""+matrix[i][j]+"\".");
                    }
                }
                res += num;
            }
        }

        return res;
    }
}
