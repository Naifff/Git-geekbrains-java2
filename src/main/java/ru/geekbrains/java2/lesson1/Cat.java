package ru.geekbrains.java2.lesson1;

import java.io.Serializable;
import java.util.Random;

/**
 *
 */
public class Cat extends Animal implements Jumpable, Serializable {

    private String n;

    public Cat(String name) {
        super(name);
//        this.name = name;
        onDistance = true;
        animType = "ru.geekbrains.java2.lesson1.Cat";
        maxRunDistance = 500;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "n='" + n + '\'' +
                '}';
    }

    @Override
    public void metod() {
        super.metod();
        System.out.println("1234567");
        System.out.println(1);
    }

    @Override
    public void info() {
        super.info();
    }

    //    @Override
    void printInfo() {

    }

    @Override
    public void jump(float height) {
        if (height < 1.5f) {
            System.out.println(animType + " jump ok");
        } else {
            float doubleJump = (new Random()).nextFloat();
            if (height < 1.5f + doubleJump) {
                System.out.println(animType + " double jump ok");
            } else
                getOutFromDistance("jump");
        }
    }


}
