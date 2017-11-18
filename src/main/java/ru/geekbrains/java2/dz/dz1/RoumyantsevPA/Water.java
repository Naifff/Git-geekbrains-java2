package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

public class Water implements PartOfCourse{
    private  float length;

    public Water(float length) {
        this.length = length;
    }

    public void doIt(TeamMember t) {
        t.swim(length);

    }
}
