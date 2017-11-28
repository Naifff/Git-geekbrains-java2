package ru.geekbrains.java2.dz.dz3.FedulovMS;

import java.util.ArrayList;

public class Passenger {
    String name;
    String docNum;

    public Passenger(String name, String docNum) {
        this.name = name;
        this.docNum = docNum;
    }

    public static ArrayList<Passenger> makeList(){
        return new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.docNum);
    }
}
