package ru.geekbrains.java2.lesson1.en;

public class Main {


    public static void main(String[] args) {
        Fruit f = Fruit.APPLE;
        System.out.println(f);
        if (f == Fruit.APPLE) {
            System.out.println("f действительно является яблоком");
        }
        switch (f) {
            case APPLE:
                System.out.println("f - яблоко");
                break;
            case ORANGE:
                System.out.println("f - апельсин");
                break;
            case CHERRY:
                System.out.println("f - вишня");
                break;
        }
    }








}
