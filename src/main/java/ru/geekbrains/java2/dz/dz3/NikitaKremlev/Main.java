package ru.geekbrains.java2.dz.dz3.NikitaKremlev;

import ru.geekbrains.java2.dz.dz3.NikitaKremlev.entity.Flight;
import ru.geekbrains.java2.dz.dz3.NikitaKremlev.entity.Passenger;
import ru.geekbrains.java2.dz.dz3.NikitaKremlev.service.FlightsService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightsService flightsService = new FlightsService();
        Scanner scanner = new Scanner(System.in);
        String name;
        Long passport;
        Long flightID;
        String exit = "n";
        while (!exit.equals("y")) {
            System.out.println("Введите имя пассажира: ");
            name = scanner.next();
            System.out.println("Введите серию и номер паспорта пассажира: ");
            passport = scanner.nextLong();
            System.out.println("Введите номер рейса пассажира: ");
            flightID = scanner.nextLong();
            while (flightID < 0 || flightID > flightsService.getCount()) {
                System.out.println("Рейса с таким номером не существует выберите рейс в диапазоне от  1 до " + flightsService.getCount());
                flightID = scanner.nextLong();
            }
            for (Flight flight : flightsService.getAllFlight()) {
                if (flightID.equals(flight.getId())) {
                    flight.setFlightPassenger(new Passenger(name, passport));
                }
                flight.writeConsole();
            }
            System.out.println("Желаете выйти? [y | n]");
            exit = scanner.next();
        }
        scanner.close();
    }
}
