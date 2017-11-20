package ru.geekbrains.java2.dz.dz1.VasilevskiyKonstantin;

public class Main {
    public static void main(String[] args) {
        Team team = new Team();
        team.getinfoTeam();
        Course course = new Course();
        course.Dolt(team);
        System.out.println("\n");
        team.showResults();
    }
}
