package ru.geekbrains.java2.dz.dz1.FedulovMS;

import ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces.*;

public class MyMain {
    public static void main(String[] args) {
        Course course = new Course();

        course.addStage(new Lane(200));
        course.addStage(new Pool(50));
        course.addStage(new Lane(100));
        course.addStage(new Fence(0.3));
        course.addStage(new Lane(1200));
        course.addStage(new Fence(1.1));
        course.addStage(new Pool(300));
        course.addStage(new Lane(90));

        Team team = new Team();

        team.addMember(new Cat("Мурзик"));
        team.addMember(new Dog("Жучка"));
        team.addMember(new Duck("Серая шейка"));
        team.addMember(new Horse("Буцефал"));
        //team.addMember(new Human("Вася")); //по задаче - 4 участника, поэтому убираю.

        course.printInfo();
        team.printInfo();

        course.doIt(team);

        team.showResults();
    }
}
