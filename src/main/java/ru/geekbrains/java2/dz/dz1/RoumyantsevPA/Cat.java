package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;


import java.util.Random;

/**
 *
 */
public class Cat extends Animal implements Jumpable {

    private String n;


    public Cat(String name) {
        super(name);
//        this.name = name;
        onDistance = true;
        animType = "Cat ";
        maxRunDistance = 500;
        maxJumpHeight = 1.5f;
    }
}
