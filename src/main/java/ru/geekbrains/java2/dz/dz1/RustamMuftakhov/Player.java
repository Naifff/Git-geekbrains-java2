package ru.geekbrains.java2.dz.dz1.RustamMuftakhov;

public class Player {

    protected int enduranceRun;
    protected int enduranceJump;
    protected int enduranceSwim;
    protected boolean ready;
    protected String name;

    public Player (int enduranceRun, int enduranceJump, int enduranceSwim, String name){

        this.enduranceRun = enduranceRun;
        this.enduranceJump = enduranceJump;
        this.enduranceSwim = enduranceSwim;
        this.name = name;

    }

    public void action (int length, int playerParameter, String action){

        if (length <= playerParameter) {
            this.ready = true;
            System.out.println(name + " has succeeded in " + action);
        }
        else {
            System.out.println(name +  " is not fit for " + action);
            this.ready = false;
        }

    }



}
