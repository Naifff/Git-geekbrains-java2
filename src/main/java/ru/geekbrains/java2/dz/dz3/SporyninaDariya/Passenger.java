package ru.geekbrains.java2.dz.dz3.SporyninaDariya;

public class Passenger {
    private String name;
    private String document;
    private int flight;

    public Passenger(String name, String document, int flight) {
        this.name = name;
        this.document = document;
        this.flight = flight;
    }

    public void setPassenger(String name){
        this.name = name;
    }

    public String getPassenger() {
        return name;
    }

    public void setDocument(String document){
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public void setFlight(int flight){
        this.flight = flight;
    }

    public int getFlight(){
        return flight;
    }
    @Override
    public String toString() {
        return getPassenger() + " " + getDocument();
    }
}

