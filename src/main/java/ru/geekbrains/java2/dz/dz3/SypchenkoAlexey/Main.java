package ru.geekbrains.java2.dz.dz3.SypchenkoAlexey;

import java.util.*;
import java.util.Scanner;

/*
 * @author Sypchenko Aleksey
 * @version 1.0 24.11.2017
 * @task 3
Задание
        Нужно реализовать рассадку пассажиров по рейсам. Каждый пассажир должен сесть на свой
        рейс. Самолет может иметь или не иметь пассажиров.
        Программа должна позволять запрашивать у пользователя ввод пассажиров, для каждого
        пассажира вводится:
        имя;
        номер документа, удовлетворяющего личность;
        номер рейса;
        По окончанию ввода пассажиров в консоль выводится список всех рейсов и отправляющихся на
        нем пассажиров (имя и номер документа). Рейсы должны быть упорядочены по номеру,
        пассажиры - по имени. Для каждого рейса указывается количество пассажиров на нем.
        Ввод данных производится по пассажирам.
        Указания
        При решении задачи нужно использовать интерфейсы List (для хранения пассажировов в рейсе)
        и Map (для сопоставления имени рейса и пассажиров в рейсе).
        При решение задачи должны быть использована одна (и только одна) TreeMap.
        Класс Passenger должен содержать только private-поля и методы доступа к нему (set/get).
*/
public class Main {
    Scanner scanner = new Scanner(System.in);
    List<Passenger> passengersList = new ArrayList<Passenger>();
    Map<Integer, List<Passenger>> flightsList = new TreeMap<Integer, List<Passenger>>();

    public static void main(String[] args) {
        Main m = new Main();
        m.inputData();
        m.printListOfCurrentFlight();
    }

    public void inputData() {
        do {
            Passenger human = new Passenger();
            System.out.println("Введите имя пассажира: ");
            human.setName(scanner.next());
            System.out.println("Введите номер документа пассажира: ");
            human.setDocument(scanner.nextInt());
            System.out.println("Введите номер рейса: ");
            int currentFlightNumber = scanner.nextInt();
            human.setFlightNumber(currentFlightNumber);
            passengersList.add(human);
            // заполняю коллекцию номерами рейсов и соответствующими им пустыми списками пассажиров
            flightsList.put(currentFlightNumber, new ArrayList<Passenger>());
            System.out.println("Для продолжения ввода введите 1, для выхода введите 0: ");
        } while (scanner.nextInt() != 0);

        for (Passenger p : passengersList) {
            flightsList.get(p.getFlightNumber()).add(p); // по номеру рейса добавляю в список пассажира
        }
    }

    public void printListOfCurrentFlight() {
        Set<Map.Entry<Integer, List<Passenger>>> set = flightsList.entrySet();
        // переопределяю сортировщик
        Comparator comparator = new Comparator<Passenger>() {

            @Override
            public int compare(Passenger s1, Passenger s2) {
                String dx1 = s1.getName();
                String dx2 = s2.getName();
                return dx1.compareTo(dx2);
            }
        };
        for (Map.Entry<Integer, List<Passenger>> f : set) { // сортировка коллекций в value
            Collections.sort(f.getValue(), comparator);
            System.out.println("Рейс " + f.getKey() + " Всего пассажиров " + f.getValue().size());
            System.out.format("%-10s %-10s", "Name", "Document");
            System.out.println();
            for (Passenger p : f.getValue()) {
                System.out.format("%-10s %-10d", p.getName(), p.getDocument());
                System.out.println();
            }
        }
    }
}
