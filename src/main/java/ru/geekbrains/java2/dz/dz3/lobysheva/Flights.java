package ru.geekbrains.java2.dz.dz3.lobysheva;

/*
 * Created by Oxana Lobysheva on 25/11/2017.
 */

import java.util.*;

public class Flights {

    private Integer[] flights;
    Map<Integer, ArrayList<Passenger>> passengers;

    public Flights(int countFlights){
        if (countFlights > 0) {
            flights = new Integer[countFlights];
            for (int i = 0; i < countFlights; i++) {
                flights[i] = new Random().nextInt(100);
            }
        } else {
            flights = new Integer[0];
        }
        passengers = new TreeMap<>();
        for (Integer flight : flights) {
            passengers.put(flight, new ArrayList<>());
        }
    }

    public void printFlightsInfo(){
        System.out.println("-------  FLIGHTS INFORMATION  ---------");
        if (passengers.size() > 0) {
            for (Map.Entry<Integer, ArrayList<Passenger>> flight : passengers.entrySet()) {
                String flightNumberInfo = "Flight = " + flight.getKey();
                String flightPassengersInfo = flight.getValue().size() + " passengers";
                System.out.println(flightNumberInfo + " : " + flightPassengersInfo);

                Collections.sort(flight.getValue(), (Passenger p1, Passenger p2) ->{
                    return p1.getName().compareToIgnoreCase(p2.getName());
                });

                for (Passenger passenger : flight.getValue()) {
                    passenger.printPassengerInfo();
                }
            }
        } else {
            System.out.println("No flights today");
        }
        System.out.println("---------------------------------------");
    }


    public Map<Integer, ArrayList<Passenger>> getPassengers(){
        return passengers;
    }

    public Integer[] getFlights(){
        return flights;
    }

    public boolean checkFlightNumber(Integer flightNumber){
        for (Integer flight : flights){
            if (flight == flightNumber) return true;
        }
        return false;
    }

}
