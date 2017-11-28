package ru.geekbrains.java2.dz.dz3.FedulovMS;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainDZ3 {
    //private static Scanner intScanner = new Scanner(System.in);
    private static Scanner strScanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<Integer, List<Passenger>> flights = new TreeMap<>();

        readInfo(flights);
        sortFlights(flights);
        printInfo(flights);

    }

    public static void readInfo(Map<Integer, List<Passenger>> data){
        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile("^(?<name>[^,]*),\\s*(?<docNum>[^,]*)\\s*,\\s*(?<flightNumber>\\d+)$");
        Matcher m;
        String line = " ";
//        String name;
//        String docNum;
//        int flightNumber;
        int cnt = 0;

        System.out.println("Введите список пассажиров");
        System.out.println("  через запятую - имя пассажира, номер документа и номер рейса, ");
        System.out.println("  по одному пассажиру в строке.");
        System.out.println("  Пустая строка - завершение ввода.");
        do {
            System.out.printf("Пассажир %d: ", ++cnt);
            if (s.hasNextLine()){
                line = s.nextLine();
                m = p.matcher(line);
                if (m.matches()) {
//                    name = m.group("name");
//                    docNum = m.group("docNum");
//                    flightNumber = Integer.parseInt(m.group("flightNumber"));
//
//                    data.computeIfAbsent(flightNumber, key -> Passenger.makeList()).add(new Passenger(name, docNum));

                    data.computeIfAbsent(
                            Integer.parseInt(m.group("flightNumber")),
                            key -> Passenger.makeList()
                    ).add(new Passenger(
                            m.group("name"),
                            m.group("docNum"))
                    );


                } else {
                    if (!line.isEmpty()){
                        System.out.println("Неверный формат ввода.");
                    }
                }
            }
        } while (!line.isEmpty());
    }

    public static void printInfo(Map<Integer, List<Passenger>> data){
        System.out.println("\nСписок рейсов:");
        for (Integer flightNumber: data.keySet()) {
            System.out.printf("  Рейс №%d:\n", flightNumber);
            for (Passenger p : data.get(flightNumber)) {
                System.out.printf("    %s\n", p);
            }
        }
    }

    public static void sortFlights(Map<Integer, List<Passenger>> data){
        for (Integer flightNumber: data.keySet()) {
            data.get(flightNumber).sort((Passenger p1, Passenger p2)->p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        }
    }
}
