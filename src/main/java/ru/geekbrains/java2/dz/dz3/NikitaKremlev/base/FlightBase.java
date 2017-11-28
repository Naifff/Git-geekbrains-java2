package ru.geekbrains.java2.dz.dz3.NikitaKremlev.base;

import ru.geekbrains.java2.dz.dz3.NikitaKremlev.entity.Flight;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует базу данных Рейсов
 */
public class FlightBase {
    private List<Flight> flights;

    public FlightBase() {
        flights = new ArrayList<>();
        Flight flightOne = new Flight(000001L, "Москва - Санкт-Петербург", 20);
        Flight flightTwo = new Flight(000002L, "Москва - Екатеренбург", 15);
        Flight flightThree = new Flight(000003L, "Москва - Сочи", 15);
        Flight flightFour = new Flight(000004L, "Москва - Париж", 10);
        Flight flightFife = new Flight(000005L, "Москва - Казань", 10);
        flights.add(flightOne);
        flights.add(flightTwo);
        flights.add(flightThree);
        flights.add(flightFour);
        flights.add(flightFife);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
