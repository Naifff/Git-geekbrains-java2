package ru.geekbrains.java2.dz.dz1.RonaldKirka;

import static ru.geekbrains.java2.dz.dz1.RonaldKirka.Team.Contestants;

public class Main {

    static Team myTeam = new Team("Ребята","Павел","Иван","Дмитрий","Рома");

    public static void main(String[] args){
        Course c = new Course();
        c.whoFinished();
        myTeam.showResults();
    }

}
