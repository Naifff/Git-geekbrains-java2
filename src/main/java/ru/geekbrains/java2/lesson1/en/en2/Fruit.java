package ru.geekbrains.java2.lesson1.en.en2;


public enum Fruit {
    ORANGE("Апельсин", 3), APPLE("Яблоко", 3), BANANA("Банан", 2), CHERRY("Вишня", 1);
    private String rus;
    private int weight;
    public String getRus() {
        return rus;
    }
    public int getWeight() {
        return weight;
    }
    Fruit(String rus, int weight) {
        this.rus = rus;
        this.weight = weight;
    }

}
