package ru.geekbrains.java2.dz.dz2.BelomestsevOleg;

public class Main {
    public static void main(String[] arg) {
        String[][] ss = new String[4][7];  // Поменять размерность массива для Первого исключения
        for (int i = 0; i < ss.length; i++)
            for (int j = 0; j < ss[0].length; j++)
                ss[i][j] = Integer.toString((int) (Math.random() * 10));

        //Раскоментировать для второго исключения, помещаем в ячейку не число: (Номер не int элемента выводится в MyArrayDataException!)
        //ss[(int) (Math.random() * ss.length)][(int) (Math.random() * ss[0].length)] = "not int";

        try {
            System.out.println("Сумма:" + method(ss));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Массив не соответствует критериям размерности!");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Элемент массива не Integer!");
        }
    }

    static int method(String[][] ss) throws MyArraySizeException, MyArrayDataException {
        int expectedSize = 4;
        if (!(ss.length == expectedSize && ss[0].length == expectedSize))
            throw new MyArraySizeException(expectedSize, expectedSize);
        int sum = 0;
        for (int i = 0; i < ss.length; i++)
            for (int j = 0; j < ss[0].length; j++) {

                //1-й вариант: используем try catch в Integer.parseInt(), ловим NumberFormatException
                try {
                    sum += Integer.parseInt(ss[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                // конец первого варианта

                //2-й вариант: через собственный обработчик, так как дополнительный try catch потребляет больше ресурсов
                //(Закоментировать 1-й вар и раскоментировать второй)
//                int a = 0, len = ss[i][j].length();
//                if (len > 0) {
//                    char firstChar = ss[i][j].charAt(0);
//                    if (firstChar < '0') {
//                        if ((firstChar == '-' || firstChar == '+') && len > 1) {
//                            a++;
//                        } else { throw new MyArrayDataException(i, j); }
//                    }
//                    while (a < len)
//                        if (!(Character.isDigit(ss[i][j].charAt(a++)))) throw new MyArrayDataException(i, j);
//                } else {throw new MyArrayDataException(i, j);}
//                sum += Integer.parseInt(ss[i][j]);
                // конец второго варианта
            }
        return sum;
    }
}

