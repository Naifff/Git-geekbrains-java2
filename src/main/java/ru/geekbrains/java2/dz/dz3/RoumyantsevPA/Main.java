package ru.geekbrains.java2.dz.dz3.RoumyantsevPA;

import java.util.*;

/*
Задание
Нужно реализовать рассадку пассажирова по рейсам. Каждый пассажир должен сесть на свой
рейс. Самолет может иметь или не иметь пассажирова.
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
и Map (для сопоставления имени рейса и пассажиров в рейсе). Предположим, что вы
реализовали класс Passenger, тогда объявления списка пассажиров следует делать следующим
образом:
List<Passenger> passengers = new ArrayList<Passenger>();
Для ввода данных имеет смысл испльзовать класс Scanner следующим образом:
Scanner scanner = new Scanner(System.in);
int flightNumber = scanner.nextInt();
При решение задачи должны быть использована одна (и только одна) TreeMap.
Класс Passenger должен содержать только private-поля и методы доступа к нему (set/get).
Используйте generics при объявление переменных с коллекциями:
Map<Integer,List<Passenger>> passengers = new TreeMap<Integer,List<Passenger>>
Для перебора элементов в коллекциях используйте for-each вариант for:
Collection<Passenger> = new ArrayList<Passenger>();
for (Passenger passenger : passengers) { }
 */
public class Main {
    public static void main(String[] args) {
        List<Passenger> passenger = new ArrayList<>();
        HashMap<Integer, TreeSet<String>> passengers = new HashMap<Integer, TreeSet<String>>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ручной ввод(1) или Автозаполнение(2)?");
        int inp = scanner.nextInt();
        if (inp == 2) {//автозаполнение
            ArrayList<Passenger> autoFill = new ArrayList<Passenger>();
            autoFill.add(new Passenger("Luis H Burch", 9795, 2));
            autoFill.add(new Passenger("Tom R Haney", 9792, 4));
            autoFill.add(new Passenger("Benjamin R Hentges", 9793, 5));
            autoFill.add(new Passenger("Colleen T Gerhardt", 9794, 6));
            autoFill.add(new Passenger("Arthur R Spicer", 9796, 1));
            autoFill.add(new Passenger("Loretta Z Lott", 9797, 5));
            autoFill.add(new Passenger("Donald R Smith", 9798, 5));
            autoFill.add(new Passenger("Joan O Rosen", 9799, 2));
            autoFill.add(new Passenger("Kristyn R Corrales", 9700, 4));
            autoFill.add(new Passenger("Marvin W Backer", 9701, 3));
            autoFill.add(new Passenger("Steven A Rice", 9702, 3));
            autoFill.add(new Passenger("John E Billman", 9703, 4));
            autoFill.add(new Passenger("Kevin S Guin", 9755, 5));
            for (Passenger p : autoFill) {
                if (passengers.containsKey(p.getFly())) {
                    TreeSet<String> psg = new TreeSet<String>();
                    psg = passengers.get(p.getFly());
                    psg.add(p.getFio() + " id: " + p.getId());
                } else {
                    TreeSet<String> psg = new TreeSet<String>();
                    psg.add(p.getFio() + " id: " + p.getId());
                    passengers.put(p.getFly(), psg);
                }
            }
        } else {//читаем данные пользователя с консоли
            while (true) {
                System.out.println("Для завершения ввода наберите \"END\"");
                System.out.println("Введите ФИО:");
                String fio = scanner.next();
                if (fio.equals("END")) {
                    break;
                }
                fio += " " + scanner.next() + " " + scanner.next();
                System.out.println("Введите номер паспорта, без пробелов:");
                int id = str2Int();
                System.out.println("Введите номер рейса:");
                int flightNumber = str2Int();
                passenger.add(new Passenger(fio, id, flightNumber));
                if (passengers.containsKey(flightNumber)) {
                    TreeSet<String> psg = new TreeSet<String>();
                    psg = passengers.get(flightNumber);
                    psg.add(fio + " id: " + id);
                } else {
                    TreeSet<String> psg = new TreeSet<String>();
                    psg.add(fio + " id: " + id);
                    passengers.put(flightNumber, psg);
                }
            }
        }
//распределяем по рейсам и по имени внутри рейсов
        for (int key : passengers.keySet()) {
            TreeSet<String> ttt = new TreeSet<String>();
            ttt = passengers.get(key);
            System.out.println(key + "[" + ttt.size() + "]" + " :");
            for (String pass : ttt
                    ) {
                System.out.println(pass);
            }
            System.out.println();

        }
    }

    private static int str2Int() {
        Scanner scanner = new Scanner(System.in);
        String s;
        int breaker;
        while (true) {
            s = scanner.next();
            breaker = 0;
            if (s.equals(null)) {
                System.out.println("Неверный ввод, попробуйте еще раз");
                breaker++;
            }
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '1':
                        break;
                    case '2':
                        break;
                    case '3':
                        break;
                    case '4':
                        break;
                    case '5':
                        break;
                    case '6':
                        break;
                    case '7':
                        break;
                    case '8':
                        break;
                    case '9':
                        break;
                    case '0':
                        break;
                    default:
                        System.out.println("Неверный ввод, попробуйте еще раз");
                        breaker++;
                }
            }
            if (breaker == 0) {
                return Integer.parseInt(s);
            }
        }
    }


}