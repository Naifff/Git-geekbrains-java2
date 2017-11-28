package ru.geekbrains.java2.dz.dz3.NikitaKremlev.service;

import ru.geekbrains.java2.dz.dz3.NikitaKremlev.base.FlightBase;
import ru.geekbrains.java2.dz.dz3.NikitaKremlev.entity.Flight;

import java.util.List;

public class FlightsService {
    private static final FlightBase FLIGHT_BASE = new FlightBase();
    private List<Flight> flights;

    public FlightsService() {
        flights = FLIGHT_BASE.getFlights();
    }

    public Integer getCount() {
        return flights.size();
    }
    public Flight getFlight(Long id) {
        return flights.get(Integer.parseInt(String.valueOf(id)));
    }
    public List<Flight> getAllFlight () {
        return flights;
    }
}
