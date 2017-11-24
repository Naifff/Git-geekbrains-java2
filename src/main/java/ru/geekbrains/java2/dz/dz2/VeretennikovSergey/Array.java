package ru.geekbrains.java2.dz.dz2.VeretennikovSergey;

public class Array implements SumArray {
    protected String [][] arr = new String[4][4];

    public Array (String [][] arr){
        if (arr.length == 4)
            this.arr = arr;
        else throw new MyArraySizeException();
    }

    public void infoArray(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void SumArray() {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    try {
                        sum = sum + Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i + 1, j + 1);
                    }
                }
            }
            System.out.print(sum);
            System.out.println();

    }
}
