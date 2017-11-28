package ru.geekbrains.java2.dz.dz3.NikitaKremlev.entity;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс реализует Рейс
 */
public class Flight {
    private static Integer number = 0;

    private Long id;
    private String placeLocation;
    private Integer count;
    private Map<Integer, Passenger> passengers;

    public Flight() {
        this.id = null;
        this.placeLocation = null;
        this.count = null;
        this.passengers = null;
    }
    public Flight(Long id, String placeLocation, Integer count) {
        this.id = id;
        this.placeLocation = placeLocation;
        this.count = count;
        this.passengers = new TreeMap<Integer, Passenger>();
    }
    public Flight(Long id, String placeLocation, Integer count, Map<Integer, Passenger> passengers) {
        this.id = id;
        this.placeLocation = placeLocation;
        this.count = count;
        this.passengers = passengers;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }
    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public Map<Integer, Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(Map<Integer, Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setFlightPassenger(Passenger passenger) {
        if (passengers != null) {
            ++number;
            if (number < count) {
                passengers.put(number, passenger);
            }
        }
    }

    public void writeConsole() {
        System.out.println("Рейс №: " + id + " маршрут \"" + placeLocation + "\". Кол-во пассажиров [" + passengers.size() + " / " + count + "]");
        if (passengers != null) {
            for (int i = 1; i < passengers.size() + 1; i++) {
                System.out.print("Место № " + i + ": ");
                passengers.get(i).writeConsole();
            }
        }
    }
}
