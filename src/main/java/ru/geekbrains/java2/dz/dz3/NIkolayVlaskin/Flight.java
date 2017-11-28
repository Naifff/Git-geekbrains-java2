package ru.geekbrains.java2.dz.dz3.NIkolayVlaskin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {

    private static final Integer MAX_COUNT_PASSENGER = 30;
    private Integer countPassenger = 0;

    private String nameFlight = "";
    List<Passenger> passengers = new ArrayList<>();

    public boolean addPassenger(Passenger passenger){
        if (passengers.size() == MAX_COUNT_PASSENGER) {
            return false;
        } else{
            this.passengers.add(passenger);
            countPassenger += 1;
            return true;
        }
    }

    public List<Passenger> getPassengers(){
        return passengers;
    }

    public String getNameFlight() {
        return nameFlight;
    }

    public void setNameFlight(String nameFlight) {
        this.nameFlight = nameFlight;
    }

    public Integer getCountPassenger() {
        return countPassenger;
    }

    public void sort(){
        Collections.sort(passengers, new CompByName());
    }
}
