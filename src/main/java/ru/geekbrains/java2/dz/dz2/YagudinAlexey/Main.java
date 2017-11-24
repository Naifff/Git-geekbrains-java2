package ru.geekbrains.java2.dz.dz2.YagudinAlexey;

public class Main {

    public static void main(String[] args) {
        int otvet;
        Massiv m = new Massiv();

// Создаём массив удовлетворяющий условиям
        String[][] massNorm = m.getMass(m.getMAX_X(),m.getMAX_Y());

// Создаём массив с неправильным размером
        String[][] massWrongSize = m.getMass(3,5);

// Создаём массив со значением которое не привести к стринге
        String[][] massWithString = m.getMassBad();

        try {

//            otvet = m.summa(massNorm);

//            otvet = m.summa(massWrongSize);

            otvet = m.summa(massWithString);

            System.out.println(otvet);

        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
