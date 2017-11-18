package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

/**
 */
public class Duck extends Animal implements Swimable {
    public Duck(String name) {
        super(name);
        // this.name = name;
        animType = "Duck ";
        onDistance = true;
        maxRunDistance = 50;
        maxSwimDistance = 15000;
    }


}
