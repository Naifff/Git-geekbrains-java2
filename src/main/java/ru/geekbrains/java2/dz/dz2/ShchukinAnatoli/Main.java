package ru.geekbrains.java2.dz.dz2.ShchukinAnatoli;

public class Main {

   public static void Arr4x4(String[][] arr4x4) {

        int size1 = arr4x4.length;
        int size2 = arr4x4[0].length;
        int sum = 0;
        int Cell_i = 0;
        int Cell_j = 0;



        if (size1 != 4 || size2 != 4) throw new MyArraySizeException("Размер не 4 на 4!");

        try {

        for (int i=0; i<arr4x4.length; i++){

            for (int j=0; j<arr4x4[i].length; j++ ){
                Cell_i=i;
                Cell_j=j;
                sum += Integer.parseInt(arr4x4[i][j]);

            }
        }  } catch (NumberFormatException e) {
            //e.printStackTrace();
            //System.out.println("Ошибка в ячейке: "+ Cell_i + " "+Cell_j);
           throw new MyArrayDataException("Ошибка в данных ",Cell_i,Cell_j);
        }

       System.out.println("Результат вычислений: " + sum);
    }




    public static void main(String[] args) {


        String[][] arr4x4 = new String[4][4];
        arr4x4 = new String[][]{{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "a"},
                {"1", "1", "1", "1"}
        };
        Arr4x4 (arr4x4);




    }
}
