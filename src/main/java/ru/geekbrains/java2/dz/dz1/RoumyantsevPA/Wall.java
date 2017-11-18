package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

public class Wall implements PartOfCourse {
   private float height;

    public Wall(float height) {
        this.height = height;
    }

    public void doIt(TeamMember t) {
            t.jump(this.height);

    }
}
