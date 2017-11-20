package ru.geekbrains.java2.dz.dz1.Korolev_Sergey;

public class MainClass {
    public static void main(String[] args){

        double runDist = 190;  // Заданная дистанция
        double jumpDist = 4.0; // Заданная высота

        Animal cat = new Cat(runDist, jumpDist);
        Animal dog = new Dog(runDist, jumpDist);
        Animal horse = new Horse(runDist, jumpDist);
        Animal human = new Human(runDist, jumpDist);


        Animal [] an = {cat, dog, horse, human};

        for(int i = 0; i < an.length; i++){
            an[i].info();
            an[i].run();
            an[i].jump();
        }
    }
}
