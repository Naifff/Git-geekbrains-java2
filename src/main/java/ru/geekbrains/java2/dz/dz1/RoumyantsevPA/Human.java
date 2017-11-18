package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

/**
 */
public class Human implements Swimable, Jumpable, TeamMember {
    String name;
    private float endurance;
    boolean onDistance;
    private float maxRunDistance;
    private float maxSwimDistance;
    private float maxJumpHeight;

    public String getName() {
        return name;
    }

    public void run(float distance) {
        if (distance <= this.maxRunDistance) {
            System.out.println("Бег - PASS");
        } else {
            this.onDistance = false;
            getOutFromDistance("Бег");
        }

    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public Human(String name) {
//        super(name);
        this.name = name;
        onDistance = true;
        maxRunDistance = 5000;
        maxJumpHeight = 1.0f;
        maxSwimDistance = 3000;
        endurance = 5000;

    }

    public void swim(float dist) {
        if (dist < maxRunDistance) {
            endurance -= dist * 10.0f;
            if (endurance < 0)
                getOutFromDistance("endurance(swim)");
            else
                System.out.println("Плыть - PASS");
        } else {
            getOutFromDistance("Плыть");
        }

    }

    public void jump(float height) {
        if (height < maxJumpHeight) {
            endurance -= height * 100;
            if (endurance < 0)
                getOutFromDistance("endurance(jump)");
            else
                System.out.println("Прыжок - PASS");
        } else {
            getOutFromDistance("Прыжок");
        }
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }

    public void getOutFromDistance(String reason) {
        System.out.println(reason + " - FAILED");
        onDistance = false;
    }

    public String getClas() {
        return "";
    }
}
