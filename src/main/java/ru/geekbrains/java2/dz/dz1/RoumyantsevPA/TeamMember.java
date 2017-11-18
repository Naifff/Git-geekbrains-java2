package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

public interface TeamMember {
    String getName();

    void run(float distance);

    void jump(float height);

    void swim(float distance);

    boolean isOnDistance();

    public String getClas();
}
