package ru.geekbrains.java2.dz.dz3.VasilevskiyKonstantin.v2;

import ru.geekbrains.java2.dz.dz3.VasilevskiyKonstantin.Passenger;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Passenger> list;
        Map<Integer, List<Passenger>> treeMap = initializationTreeMap();

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

    public static Passenger getPassengerWithEnterToConsole() {
        System.out.println("Enter data: Name, Number document, Number flight");
        System.out.print("Name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.print("Number document: ");
        int numberDocument = scanner.nextInt();

        System.out.print("Number flight: ");
        int numberFlight = scanner.nextInt();

        return new Passenger(name, numberDocument, numberFlight);
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

    public static Map<Integer,List<Passenger>> initializationTreeMap(){
        int flightNumber;
        Passenger passenger;
        List<Passenger> list;
        Map<Integer,List<Passenger>> treeMap = new TreeMap<Integer,List<Passenger>>();

        do {
            passenger = getPassengerWithEnterToConsole();

            flightNumber = passenger.getFlightNumber();

            if(treeMap.containsKey(flightNumber)) {
                list = treeMap.get(flightNumber);
            } else {
                list = new ArrayList<Passenger>();
            }

            list.add(passenger);
            treeMap.put(flightNumber, list);
        } while(getAnswerEnterPassenger());

        return treeMap;
    }

}

