package ru.geekbrains.java2.dz.dz2.PospelovaElena;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        String[][] arrayWrong1 = new String[5][5];
        String[][] arrayWrong2 = new String[4][4];
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                arrayWrong2[i][j]=i+"0"+j;
            }
        }
        arrayWrong2[3][3]="a21";

        //checkSize(arrayWrong1);
        checkFormatAndSum(arrayWrong2);





    }
    public static void checkSize(String[][] arr){
        if ((arr.length!=4)||(arr[0].length!=4)) { throw new MyArraySizeException();
        }
    }

    public static void checkFormatAndSum(String[][] arr){
        int row = 0;
        int col = 0;
        int sum = 0;
        try {
            for (int i=0;i<4;i++){
                row = i;
                for (int j=0;j<4;j++){
                    col=j;
                    sum+= parseInt(arr[i][j]);
                }
            }
            System.out.println("Cумма: "+sum);
        } catch (NumberFormatException a){

            throw new MyArraySizeException("строка "+row+" стролбец "+col);

        } finally {
            System.out.println("Конец");
        }

    }
}
