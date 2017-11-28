package ru.geekbrains.java2.dz.dz3.RustamMuftakhov;

import java.util.Comparator;

public class PassengerNameComparator implements Comparator<Passenger> {

    public int compare (Passenger p1, Passenger p2){
        return p1.getName().compareTo(p2.getName());
    }
}
