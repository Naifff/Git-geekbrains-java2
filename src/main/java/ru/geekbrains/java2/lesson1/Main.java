package ru.geekbrains.java2.lesson1;

/**
 * Created by Home-pc on 18.08.2016.
 */
public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        String s = car.name3;
        String s2 = car.name2;
        Animal human;
        human = new Human("name");
        System.out.println(human.getName());
//human.getName().split(" ")[0].isEmpty();
//        Animal animal = new Animal("23342");
    }
}
