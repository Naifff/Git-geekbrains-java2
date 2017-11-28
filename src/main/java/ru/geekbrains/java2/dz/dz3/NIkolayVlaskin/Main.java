package ru.geekbrains.java2.dz.dz3.NIkolayVlaskin;


import java.util.*;

public class Main {

    private Flight flight_1;
    private Flight flight_2;
    private Map<Integer, Flight> flightList;

    public Main() {
        FlightFactory flightFactory = new FlightFactoryImpl();
        flight_1 = flightFactory.createFlightMoscowBarnaul();
        flight_2 = flightFactory.createFlightMoscowTyumen();
        flightList = new TreeMap<>();
        flightList.put(1, flight_1);
        flightList.put(2, flight_2);
    }

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println("Можно зарегистрировать на рейсы:");
        for (Map.Entry<Integer, Flight> name: main.flightList.entrySet()){
            System.out.println(name.getValue().getNameFlight());
        }
        System.out.println("Выедите регистрационные данные в форме: ваше имя, номер документа, номер рейса");

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("quit")){
            Passenger passenger = main.inputPassenger(scanner);

            if (passenger.getFlightNumber() == 1) {
                if(!main.flight_1.addPassenger(passenger)) System.out.println("Уже зарегистрировано максимальное кол-во пассажиров;");
            }
            else if (passenger.getFlightNumber() == 2) {
                if(!main.flight_2.addPassenger(passenger)) System.out.println("Уже зарегистрировано максимальное кол-во пассажиров;");
            }

            System.out.println("Если вы зкончили вводить пассажиров наберите quit");
        }

        main.flight_1.sort();
        main.flight_2.sort();

        main.showResult();
    }

    private Passenger inputPassenger(Scanner scanner){
        Passenger passenger = new Passenger();
        passenger.setName(verifyInputString(scanner));
        passenger.setDocumentNumber(verifyInputInteger(scanner));
        passenger.setFlightNumber(verifyInputInteger(scanner));
        return passenger;
    }

    private String verifyInputString(Scanner scanner){
        while (scanner.hasNext("[0-9]")){
            System.out.println("Введите строку!");
            scanner.next();
        }
        return scanner.next();
    }

    private Integer verifyInputInteger(Scanner scanner){
        while (!scanner.hasNextInt()){
            System.out.println("Введите число!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void showResult(){
        System.out.println();
        System.out.println("Информация о заказе:");
        for (Map.Entry<Integer, Flight> flight: flightList.entrySet()){
            System.out.println("Рейс: " + flight.getValue().getNameFlight());
            System.out.println("Общее количиство пасаажирова на рейсе:" + flight.getValue().getCountPassenger());
            System.out.println("Пассажиры:");
            for (Passenger passenger : flight.getValue().getPassengers()){
                System.out.println("      Имя: " + passenger.getName() + "; Номер документа: " + passenger.getDocumentNumber());
            }
            System.out.println();
        }
    }
}
