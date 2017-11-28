package ru.geekbrains.java2.dz.dz3.NIkolayVlaskin;

import java.util.Comparator;

public class CompByName implements Comparator<Passenger> {

    @Override
    public int compare(Passenger e1, Passenger e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
