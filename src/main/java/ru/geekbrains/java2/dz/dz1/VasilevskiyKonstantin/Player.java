package ru.geekbrains.java2.dz.dz1.VasilevskiyKonstantin;

public class Player {
    private  String name;
    private int power;
    private boolean passed;
    private Barrier barrier;

    public Player(String name, int power) {
        this.name = name;
        this.power = power;
        this.passed = true;
    }

    public String getInfoPlayer() {
        return name + " " + power;
    }

    public String getInfoShowResultPlayer() {
        if (!passed) {
            return name + " failed on the obstacle \"" + barrier.getName() + "\", she did not have "
                    + barrier.getForce() + " units";
        }
        else return name + " coped, left " + power + " units of force";
    }

    public int getPower() {
        return power;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
    }
}
