package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

/**
 */
public class Dog extends Animal implements Swimable, Jumpable {

    public Dog(String name) {
        super(name);
        //  this.name = name;
        onDistance = true;
        animType = "Dog ";
        maxRunDistance = 1000;
        maxSwimDistance = 300;
        maxJumpHeight = 0.5f;
    }


}
