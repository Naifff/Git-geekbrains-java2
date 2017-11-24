package ru.geekbrains.java2.dz.dz3.RoumyantsevPA;

public class Passenger {
    private String fio;
    private int id;
    private int fly;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFly(int fly) {
        this.fly = fly;
    }

    public String getFio() {

        return fio;
    }

    public int getId() {
        return id;
    }

    public int getFly() {
        return fly;
    }

    public Passenger(String fio, int id, int fly) {
        this.fio = fio;
        this.id = id;
        this.fly = fly;
    }
//
//    public void printPass(){
//        System.out.println("FIO: "+this.fio+"\n id: "+this.id+"\n Рейс: "+this.fly);

    }
}
