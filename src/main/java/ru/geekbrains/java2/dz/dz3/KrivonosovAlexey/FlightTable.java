package ru.geekbrains.java2.dz.dz3.KrivonosovAlexey;

import java.util.*;

public class FlightTable {
    private Map<Integer, List<Passenger>> mp = new TreeMap<>();

    public Map<Integer, List<Passenger>> initFlightTable(){

       Scanner sc = new Scanner(System.in);
       int j = 1;
       while(j != 0) {
           try {
               System.out.print("Ввод данных о пассажире. Введите номер рейса:");
               int flightNumber = sc.nextInt();
               System.out.print("Введите номер документа:");
               int documentNumber = sc.nextInt();
               System.out.print("Введите имя пассажира:");
               String name = sc.next();
               if (!mp.containsKey(flightNumber)) mp.put(flightNumber, new ArrayList<Passenger>());
               mp.get(flightNumber).add(new Passenger(name, documentNumber));



           System.out.println("Добавить следующего пассажира? 1- да, 0 - нет, 2 - создать пустой рейс.");
           j = sc.nextInt();
           while(j == 2){
               System.out.println("Введите номер рейса:");
               j = sc.nextInt();
               if(!mp.containsKey(j)) mp.put(j,new ArrayList<Passenger>()); else System.out.println("Рейс уже создан");
               System.out.println("Добавить следующего пассажира? 1- да, 0 - нет, 2 - создать пустой рейс.");
               j = sc.nextInt();
           }
           } catch(InputMismatchException e){
               System.out.println("Ошибка! Неверный тип данных.");
               j = 0;
           }
       }
   return mp;
   }


   public void printFlightTable(){
       Set <Integer> k = mp.keySet();
       for (Integer o: k) {
           System.out.println("Номер рейса: " + o);
           System.out.println("Количество пассажиров: " + mp.get(o).size());
           if(!mp.get(o).isEmpty()) System.out.println("Имя пассажира // Номер документа"); else System.out.println("Нет пассажиров");
           mp.get(o).sort(Passenger.COMPARE_BY_NAME);
           for (Passenger a:mp.get(o)) {
               System.out.println(a.getPassengerName() + " // " + a.getDocumentNumber());
           }
           System.out.println();
       }
   }


}
