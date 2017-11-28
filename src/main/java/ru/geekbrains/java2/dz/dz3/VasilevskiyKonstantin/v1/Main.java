package ru.geekbrains.java2.dz.dz3.VasilevskiyKonstantin.v1;

import ru.geekbrains.java2.dz.dz3.VasilevskiyKonstantin.Passenger;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Passenger> list;
        List<Passenger> passengers = initializationPassengers();
        Map<Integer, List<Passenger>> treeMap = initializationTreeMap(passengers);

        for (Map.Entry e : treeMap.entrySet()) {
            System.out.println("Flight number: " + e.getKey());

            list = (List<Passenger>) e.getValue();
            Collections.sort(list, Passenger.COMPARE_BY_NAME);

            System.out.println("On board " + list.size() + " people(s): ");
            System.out.println("Name\t\tNumber document");
            for (Passenger passenger : list) {
                System.out.println(passenger.getName() + "\t\t\t" + passenger.getDocumentNumber());
            }
            System.out.println("");
        }
    }

    public static List<Passenger> initializationPassengers() {
        List<Passenger> passengers = new ArrayList<Passenger>();

        do {
            addWithEnterToConsole(passengers);
        } while(getAnswerEnterPassenger());

        return passengers;
    }

    public static void addWithEnterToConsole(List<Passenger> passengers) {
        System.out.println("Enter data: Name, Number document, Number flight");
        System.out.print("Name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.print("Number document: ");
        int numberDocument = scanner.nextInt();

        System.out.print("Number flight: ");
        int numberFlight = scanner.nextInt();

        Passenger passenger = new Passenger(name, numberDocument, numberFlight);
        passengers.add(passenger);
    }

    public static boolean getAnswerEnterPassenger() {
        int num;

        System.out.println("You want to introduce one more passenger?");
        System.out.print("1 - YES, 0 - NO: ");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();

            if (num == 0 || num == 1) {
                System.out.println("");
                break;
            }

            System.out.println("Enter the correct number");
        }

        return num == 1;
    }

    public static Map<Integer,List<Passenger>> initializationTreeMap(List<Passenger> passengers){
        List<Passenger> list;
        Map<Integer,List<Passenger>> treeMap = new TreeMap<Integer,List<Passenger>>();

        int flightNumber;
        for (Passenger passenger:passengers) {
            flightNumber = passenger.getFlightNumber();

            if(treeMap.containsKey(flightNumber)) {
                list = treeMap.get(flightNumber);
            } else {
                list = new ArrayList<Passenger>();
            }

            list.add(passenger);
            treeMap.put(flightNumber, list);
        }

        return treeMap;
    }

}


