package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

public class Main {
    public static void main(String[] args){
        Team team = new Team("Ферма", new Animal[]{new Cat("Мурзик"), new Dog("Шарик"), new Duck("Утка")});

        System.out.println("----------");
        team.getAll();
        System.out.println("----------");

        Cource cource = new Cource(new Barier[]{new BarierRun(), new BarierJump(), new BarierRun(), new BarierSwim()});
        cource.dolt(team);

        System.out.println("----------");
        team.showResults();
        System.out.println("----------");
    }
}
