package ru.geekbrains.java2.dz.dz3.SporyninaDariya;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Passenger>> passengersMap = new TreeMap<Integer, List<Passenger>>();
        List<Passenger> flight1 = new ArrayList<>();
        List<Passenger> flight2 = new ArrayList<>();
        List<Passenger> flight3 = new ArrayList<>();
        System.out.println("Доступны рейсы: 1, 2, 3");

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные пассажира.");
            System.out.println("Введите фамилию, паспорт, номер рейса");
            String name = scanner.next();
            String document = scanner.next();
            int flightNumber = scanner.nextInt();
            switch (flightNumber){
                case 1 : flight1.add(new Passenger(name, document, flightNumber)); break;
                case 2 : flight2.add(new Passenger(name, document, flightNumber)); break;
                case 3 : flight3.add(new Passenger(name, document, flightNumber)); break;
                default : System.out.println("Неверный номер рейса");
            }
        }

        passengersMap.put(1, flight1);
        passengersMap.put(2, flight2);
        passengersMap.put(3, flight3);

        Comparator<Passenger> c = (name1, name2) -> name1.getPassenger().compareToIgnoreCase(name2.getPassenger());
        flight1.sort(c);
        flight2.sort(c);
        flight3.sort(c);

        for (Map.Entry e : passengersMap.entrySet()) {
            System.out.println("Рейс номер " + e.getKey() + " пассажиры:");
            for (Passenger pp : (ArrayList<Passenger>)e.getValue()) {
                System.out.println("  " + pp.getPassenger() + " " + pp.getDocument());
            }
            System.out.println("Всего пассажиров: " + ((ArrayList<Passenger>) e.getValue()).size() + "\n");
        }
    }
}
