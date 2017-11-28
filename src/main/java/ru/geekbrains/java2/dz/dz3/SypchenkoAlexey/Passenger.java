package ru.geekbrains.java2.dz.dz3.SypchenkoAlexey;

public class Passenger {
    private String name;
    private int document;
    private int flightNumber;

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getName() {
        return name;
    }

    public int getDocument() {
        return document;
    }

    public int getFlightNumber() {
        return flightNumber;
    }
}
