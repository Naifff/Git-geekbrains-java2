package ru.geekbrains.java2.dz.dz3.lobysheva;

/*
 * Created by Oxana Lobysheva on 23/11/2017.
 */

import java.util.*;

public class CheckIn {

    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);

        String userResponse = "y";
        String passengerName;
        int passengerPassport;
        int passengerFlightNumber;

        try {

            Flights flights = new Flights(4);
            flights.printFlightsInfo();
            System.out.println("Check-In started");

            do {
                try {
                    if (flights.getFlights().length == 0) break;

                    System.out.println("INPUT PASSENGER ? y - yes, n - no");
                    userResponse = scanner.nextLine();

                    if ("y".equalsIgnoreCase(userResponse)) {

                        System.out.println("Enter passenger's name");
                        passengerName = scanner.nextLine();
                        if (passengerName.isEmpty()) passengerName = "VIP ?";

                        System.out.println("Enter passenger's passport number");
                        passengerPassport = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter passenger's flight number:");
                        passengerFlightNumber = Integer.parseInt(scanner.nextLine());

                        if (!flights.checkFlightNumber(passengerFlightNumber))
                            throw new FlightNumberException("Flight number doesn't exist");

                        flights
                                .getPassengers()
                                .get(passengerFlightNumber)
                                .add(new Passenger(passengerName, passengerPassport, passengerFlightNumber));

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Number Format Exception");
                } catch (FlightNumberException e) {
                    e.printExceptionMessage();
                }

            } while ("y".equalsIgnoreCase(userResponse));

            System.out.println("Check-In finished. Total = " + Passenger.getCountPassengers() + " passengers");
            flights.printFlightsInfo();

        } finally {
            scanner.close();
        }
    }
}
