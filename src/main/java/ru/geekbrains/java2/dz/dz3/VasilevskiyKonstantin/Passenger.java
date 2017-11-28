package ru.geekbrains.java2.dz.dz3.VasilevskiyKonstantin;

import java.util.Comparator;

public class Passenger {
    private String name;
    private int documentNumber;
    private int flightNumber;

    public Passenger(String name, int documentNumber, int flightNumber) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.flightNumber = flightNumber;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getName() {
        return name;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public static final Comparator<Passenger> COMPARE_BY_NAME = new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
}
