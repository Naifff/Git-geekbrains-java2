package ru.geekbrains.java2.dz.dz2.RoumyantsevPA;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        String[][] fXf=new String[4][4];
        for(int i=0;i<fXf.length; i++){
            for (int j=0;j<fXf[0].length;j++){
                fXf[i][j]=""+rnd.nextInt(300);

            }
        }
 //       fXf[0][0]="n";
int result=myMethod(fXf);
        for(int i=0;i<fXf.length;i++){
            System.out.println(Arrays.toString(fXf[i]));
        }
        System.out.println("\n Count: "+result );

    }

    private static int myMethod (String[][] fourXfour){
        if(fourXfour.length==4&&fourXfour[0].length==4){
          //  System.out.println("GJ");
            int count=0;
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                   try {
                       count += Integer.parseInt(fourXfour[i][j]);
                   }catch (NumberFormatException f){
                       try {
                           throw new MyArrayDataException("Ошибка в элементе: ["+i+"]["+j+"] = "+fourXfour[i][j]);
                       } catch (MyArrayDataException e) {
                           e.printStackTrace();
                       }
                   }

                }
            }
            return count;
        }else{
            try {
                throw new MySizeArrayException("Не соответствует размеру 4х4");
            } catch (MySizeArrayException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }
}
