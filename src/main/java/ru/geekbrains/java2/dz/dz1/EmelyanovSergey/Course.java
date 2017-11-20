package ru.geekbrains.java2.dz.dz1.EmelyanovSergey;

import java.lang.reflect.Member;

public class Course implements Courseable, Info {

    private String nameOfCource; //Название полосы препятствий

    BarriersENum[] barriers;

    public Course(String nameOfCource, BarriersENum[] barriers) {
        this.nameOfCource = nameOfCource;
        this.barriers = barriers;
    }

    public int getPowerOfCource() {
        int powerCourse = 0;
        for (BarriersENum b : barriers) {
            powerCourse += b.getPowerToPass();
        }
        return powerCourse;
    }

    public void doit(Teamable t) {

        System.out.println(getInfo()+" принимает команду " + t.getTeamName());
        t.goToCource(this); //потому что проходит полосу команда И все действия над командой происходят в команде
    }

    public String getInfo() {
        return "Полоса " + nameOfCource + " (Трудоемкость:" + getPowerOfCource() + ")";
    }

    public void getAllInfo() {
        System.out.println("Состав полосы препятствий "+this.nameOfCource+":");
        for (BarriersENum b : barriers) {
            System.out.println(b.getRusName()+" трудоемкость:"+b.getPowerToPass());
        }

    }
}
