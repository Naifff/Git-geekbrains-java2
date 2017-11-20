package ru.geekbrains.java2.dz.dz1.EmelyanovSergey;

public interface Courseable extends Info{


    String nameOfCource = "";
    BarriersENum[] barriers = new BarriersENum[0]; //барьеры

    void doit(Teamable t);
    int getPowerOfCource();
    String getInfo();
}
