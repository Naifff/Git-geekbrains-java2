package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

public class Cross implements PartOfCourse{
    private float length;

    public Cross(float length) {
        this.length = length;
    }

    public void doIt(TeamMember t) {
        t.run(length);
    }
}
