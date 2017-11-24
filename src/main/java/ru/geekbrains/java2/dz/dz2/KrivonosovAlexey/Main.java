package ru.geekbrains.java2.dz.dz2.KrivonosovAlexey;


public class Main {
    public static void main(String[] args) {
        Array arr = new Array();
        String [][] mass = new String [4][4];
        arr.randomize(mass);
        mass[2][3] = "wefwef";
        arr.print(mass);
        int g = 0;
        try {
            g = arr.summOfElements(mass);
            System.out.println("Результат расчета суммы элементов: " + g);
        }
        catch(MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
            System.out.println("Ошибка! Рассчет не удался.");
        }


    }


}


