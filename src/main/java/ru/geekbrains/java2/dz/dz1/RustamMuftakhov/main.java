package ru.geekbrains.java2.dz.dz1.RustamMuftakhov;

public class main {

    public static void main(String[] args) {

        Player Vasya = new Player(1500, 30, 200, "Vasya");
        Player Kolya = new Player(900, 20, 100, "Kolya");
        Player Tolya = new Player(1200, 40, 300, "Tolya");
        Player Zhenya = new Player(500, 10, 50, "Zhenya");

        Course course = new Course();
        Team team = new Team("Tigers", Vasya, Kolya, Tolya, Zhenya);

        course.runCourse(team);

        team.whoPassedTheCourse();
        team.teamInfo();

    }


}
