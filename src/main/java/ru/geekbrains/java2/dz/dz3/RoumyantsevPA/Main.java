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
        Map<Integer, List<Passenger>> passengers = new TreeMap<Integer, List<Passenger>>();
        Scanner scanner = new Scanner(System.in);
//читаем данные пользователя с консоли
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
            Passenger man = new Passenger(fio, id, flightNumber);
            if (passengers.containsKey(flightNumber)) {
                passengers.get(flightNumber).add(man);
            } else {
                List<Passenger> ttt = new ArrayList<Passenger>();
                ttt.add(man);
                passengers.put(flightNumber, ttt);
            }
        }
//распределяем по рейсам и по имени внутри рейсов
        for (int key : passengers.keySet()) {
            List<Passenger> ttt = new ArrayList<Passenger>();
            ttt = passengers.get(key);
            TreeSet<String> printMe = new TreeSet<>();
            for (Passenger pass : ttt
                    ) {
                printMe.add("\n" + pass.getFio() + "  id:" + pass.getId());
            }
            System.out.println(key + "[" + printMe.size() + "]" + " :");
            System.out.println(printMe);
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