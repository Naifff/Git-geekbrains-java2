package ru.geekbrains.java2.dz.dz2.AndreyMelchuk;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при
//        подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int, и
//        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
//                ячейке лежит символ или текст вместо числа), должно быть брошено исключение
//        MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

//        3 В методе main() вызвать полученный метод, обработать возможные исключения
//        MySizeArrayException и MyArrayDataException, и вывести результат расчета.

        //Нормальный размер и данные
        String[][] TestString4x4 = {
                {"00","01","02","03"},
                {"10","11","12","13"},
                {"20","21","22","23"},
                {"30","31","32","33"}
        };

        //Нормальный размер, битые данные
        String[][] TestString4x4bad = {
                {"00","01","02","03"},
                {"10","11s","12","13"},
                {"20","21","22s","23a"},
                {"30","31","32","33b"}
        };

        //Плохой размер
        String[][] TestString1x2= {{"11"},{"22"}};

        System.out.println("\n\nMain::Тест 1, правильного массива.");
        mainExceptionsHandler(TestString4x4);

        System.out.println("\n\nMain::Тест 2, массива с неправильным размером.");
        mainExceptionsHandler(TestString1x2);

        System.out.println("\n\nMain::Тест 3, массива с правильным размером, но с битым элементом.");
        mainExceptionsHandler(TestString4x4bad);


        System.out.println("\n\nMain::Тесты завершены.");
    }

    /*
        Главный обработчик
     */
    private static void mainExceptionsHandler(String[][] s){
        try{
            stringArray4x4Test(s);
        }catch (MyArrayDataException e) {
            System.out.print("    Main:: MyArrayDataException :: Битые адреса: ");
            for (int i =0;i < ((MyArrayDataException) e).crash_index.length;i++)
                System.out.print(((MyArrayDataException) e).crash_index[i]+(i%2==0?",":"   "));
        }catch (MyArraySizeException e){
            System.out.println("    Main:: MyArraySizeException :: Неправильный размер массива.");
        }catch (Exception e){
            System.out.println("    Main:: Обработчик не задан.");
        }
    }

    /*
        Метод работы с массивом и генерация исключений
        Складываем все удачно сконвертированные элементы
     */
    private static void stringArray4x4Test(String[][] s4x4) throws MyArraySizeException,MyArrayDataException{
        System.out.println("    stringArray4x4Test:: Получен на вход массив с размерностью [" +s4x4.length + "," + s4x4[0].length +"]" );
        //assert s4x4.length == 4;
        //assert s4x4[0].length == 4;
        if(s4x4.length != 4 || s4x4[0].length != 4) {
            System.out.println("    stringArray4x4Test:: Расчет невозможно завершить.");
            throw new MyArraySizeException(); //Проверяем количество рядов и колонок
        }
        int sum = 0;
        boolean isNumberFormatExceptionRecieved = false;
        ArrayList<Integer> bad_data_list = new ArrayList<Integer>();

        for (int i = 0; i < s4x4.length; i++) {
            for (int j = 0; j < s4x4[0].length; j++) {
                try { //Сумма с конвертацией
                    sum += Integer.parseInt(s4x4[i][j]);
                }catch (NumberFormatException e){
                    bad_data_list.add(i);bad_data_list.add(j);
                    isNumberFormatExceptionRecieved = true; //Устанавливаем флаг
                }
            }
        }

        System.out.println("    stringArray4x4Test:: Сумма удачно сконвертированных элементов " + sum);

        if(isNumberFormatExceptionRecieved){
            //Эскалация NumberFormatException в наше исключение c парами i,j адресов
//            new MyArrayDataException(1,4,5,6,7);
//            new MyArrayDataException(1,4,5,6,7,6,7,8,8);
//            new MyArrayDataException(1,4,5,7);
//            new MyArrayDataException(1,4,5,6,7,7,8,9,2,4,6);
//            Integer[] integers = new Integer[2];
//            integers[0] = 50;
//            integers[1] = 60;
//            new MyArrayDataException(integers);
            throw new MyArrayDataException(bad_data_list.stream().toArray(Integer[]::new));
        }
    }
}
