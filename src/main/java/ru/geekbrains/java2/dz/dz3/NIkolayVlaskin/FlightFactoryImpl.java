package ru.geekbrains.java2.dz.dz3.NIkolayVlaskin;

public class FlightFactoryImpl implements FlightFactory {

    @Override
    public Flight$Moscow$Barnaul createFlightMoscowBarnaul() {
        return new Flight$Moscow$Barnaul();
    }

    @Override
    public Flight$Moscow$Tyumen createFlightMoscowTyumen() {
        return new Flight$Moscow$Tyumen();
    }
}
