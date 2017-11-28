package ru.geekbrains.java2.dz.dz3.RustamMuftakhov;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PassengerNameComparator pnc = new PassengerNameComparator();
        List<Passenger> passengers = new ArrayList<Passenger>(); // Список всех пассажиров, куда заносятся данные при вводе пользователем
        Map<Integer, List<Passenger>> map = new TreeMap<Integer, List<Passenger>>();

        int finishInput = 1;

        while (finishInput != 0) {
            Passenger passenger = new Passenger();
            List<Passenger> flightList; //Список пассажиров на один рейс, записывается как Value в TreeMap

            System.out.println("Введите имя пассажира");
            String name = scanner.next();
            System.out.println("Введите номер документа");
            int doc = scanner.nextInt();
            System.out.println("Введите номер рейса");
            int flightNumber = scanner.nextInt();

            passenger.setName(name);
            passenger.setDoc(doc);

            passengers.add(passenger);
            if (!map.containsKey(flightNumber)) {
                flightList = new ArrayList<Passenger>();
                map.put(flightNumber, flightList); //Добавление пассажира в список и рейса в TreeMap в качестве ключа (вместе с пустым списком)
            }
            flightList = map.get(finishInput);
            flightList.add(passenger);

            System.out.println("Продолжить ввод пассажиров? 1 - да, 0 - нет");
            finishInput = scanner.nextInt();

            if (finishInput == 0) break;
        }

        for (Integer flightNumber : map.keySet()){ // Вывод полученного списка в консоль
            System.out.println("Номер рейса: " + flightNumber + " Количество пассажиров " + map.get(flightNumber).size());
            List<Passenger> passengers2 = map.get(flightNumber);
            Collections.sort(passengers2, pnc);
            for(Passenger passenger: passengers2){
                System.out.println("Имя пассажира: " + passenger.getName() + "; Номер документа: " + passenger.getDoc());
            }
            System.out.println(" ");
        }
    }
}
