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
        List<Passenger> passengers = new ArrayList<Passenger>();
        Map<Integer,List<Passenger>> passengers = new TreeMap<Integer,List<Passenger>>();
        Collection<Passenger> ttt= new ArrayList<Passenger>();
        for (Passenger passenger : ttt) { }
    Scanner scanner = new Scanner(System.in);

    String fio = scanner.next()+" "+scanner.next()+" "+scanner.next();
    int id = scanner.nextInt();
    int flightNumber = scanner.nextInt();

    Passenger man = new Passenger(fio, id, flightNumber);
    //man.printPass();
}

}