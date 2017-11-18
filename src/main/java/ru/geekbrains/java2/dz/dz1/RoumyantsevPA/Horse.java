package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

/**
 */
public class Horse extends Animal implements Swimable, Jumpable {
    public Horse(String name) {
        super(name);
        // this.name = name;
        animType = "Horse ";
        onDistance = true;
        maxRunDistance = 10000;
        maxSwimDistance = 10;
        maxJumpHeight = 1.0f;
    }


}
