package ru.geekbrains.java2.lesson1.en.en2;


public class Main {
    public static void main(String[] args) {
        for(Fruit o : Fruit.values()) {
            System.out.printf("Средний вес фрукта %s составляет: %d ед.\n", o.getRus(), o.getWeight());
        }
    }

}
