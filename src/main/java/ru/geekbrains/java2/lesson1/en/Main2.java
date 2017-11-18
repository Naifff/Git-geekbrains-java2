package ru.geekbrains.java2.lesson1.en;


public class Main2 {

    public static void main(String[] args) {
        System.out.println("Все элементы перечисления:");
        for(Fruit o : Fruit.values()) {
            System.out.println(o);
        }
        System.out.println("Поиск элемента по названию: " + Fruit.valueOf("BANANA"));
    }
}
