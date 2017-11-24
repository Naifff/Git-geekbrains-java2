package ru.geekbrains.java2.dz.dz2.YagudinAlexey;
import java.util.Random;

public class Massiv {


    private final int MAX_X = 4;
    private final int MAX_Y = 4;
    private String[][] mass;

    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }

    //Возвращает массив заданного размера заполненого числами в формате стринги

    public String[][] getMass(int x, int y) {
        mass = new String[x][];
        Random r = new Random();
        for(int i = 0; i < x; i++){
            mass[i] = new String[y];
            for(int j = 0; j < y; j++){
                mass[i][j] = Integer.toString(r.nextInt(100));
            }
        }
        return mass;
    }


    //"Портит" одну из ячеек буквами

    public String[][] getMassBad() {
        mass = getMass(MAX_X,MAX_Y);
        Random r = new Random();
        mass[r.nextInt(MAX_X)][r.nextInt(MAX_Y)] = "BAD";
        return mass;
    }

    //Метод, который суммирует либо кидается исключениями

    public int summa(String[][] strings) throws MyArrayDataException, MyArraySizeException{

        if(mass.length != MAX_X) throw new MyArraySizeException("Размер массива не 4X4");
        for(String[] s : strings){
            if(s.length != MAX_Y) throw new MyArraySizeException("Размер массива не 4X4");
        }

        int summ = 0;

        for(int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++){
                try{
                    summ = summ + Integer.parseInt(strings[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Невозможно привеси значение в ячейке " + (i+1) +":" + (j+1) + " к числовому типу" );
                }
            }
        }
    return summ;
    }

//    public void printMass(String[][] strings){
//        for(String[] sLine: strings){
//            for(String s: sLine)
//                System.out.print(s + ' ');
//            System.out.println();
//        }
//    }
}
