package ru.geekbrains.java2.lesson1;
public class MainClass {
    public static void main(String[] args) {
        Swimable[] an = new Swimable[5];
//        an[0] = new Cat("Barsik");
        an[1] = new Dog("Bobik");
        an[2] = new Duck("Donald");
        an[3] = new Horse("Spirit");
        an[4] = new Human("Bob");




        for (int i = 0; i < an.length; i++) {
            an[i].swim(3);

        }

//        for (int i = 0; i < an.length; i++) {
//            if(an[i].isOnDistance())
//                System.out.println(an[i].getName() + " WIN");
//        }
    }
}
