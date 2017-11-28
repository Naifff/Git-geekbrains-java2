package ru.geekbrains.java2.dz.dz3.lobysheva;

/*
 * Created by Oxana Lobysheva on 24/11/2017.
 */

public class Passenger {

    private String name;
    private int passportNumber;
    private int flightNumber;
    private static int countPassengers = 0;

    public Passenger(String name, int passportNumber, int flightNumber){
        this.name = name;
        this.passportNumber = passportNumber;
        this.flightNumber = flightNumber;
        countPassengers++;
    }

    public void printPassengerInfo(){
        System.out.println("  Passenger name = " + name + " Passport number = " + passportNumber);
    }

    public static int getCountPassengers(){
        return countPassengers;
    }

    public String getName() {
        return name;
    }

}
