package ru.geekbrains.java2.dz.dz1.KrivonosovAlexey;

public class Main {

    public static void main(String[] args) {
        Team tm = new Team("Team!", 4);
        tm.getTeamInfo();
        Course cur = new Course();
        cur.getCourseInfo();
        cur.dolt(tm);
        tm.showResults();
    }
}
