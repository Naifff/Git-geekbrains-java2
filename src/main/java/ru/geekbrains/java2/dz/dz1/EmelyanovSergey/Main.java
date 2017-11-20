package ru.geekbrains.java2.dz.dz1.EmelyanovSergey;

public class Main {

    public static void main(String[] args) {
	// write your code here


        BarriersENum[] bars_hard = {BarriersENum.SIMPLE_BAR,
                BarriersENum.FIRE_BAR,
                BarriersENum.WATER_PIT,
                BarriersENum.CABLE,
                BarriersENum.SIMPLE_BAR,
                BarriersENum.FENCE,
                BarriersENum.FIRE_BAR
        };
        BarriersENum[] bars_light = {BarriersENum.SIMPLE_BAR,
                BarriersENum.WATER_PIT,
                BarriersENum.SIMPLE_BAR,
        };



        Courseable c_hard = new Course("ПолосаТрудная",bars_hard);
        Courseable c_light = new Course("ПолосаЛегкая",bars_light);
        Teamable team = new Team("МЕЧТА");


        System.out.println("-------------------------------");
        Info info = c_hard;
        info.getAllInfo(); //getAllInfo не объявлен в интерфейсе Courseable
        System.out.println("-------------------------------");
        ((Course) c_hard).getAllInfo(); //getAllInfo не объявлен в интерфейсе Courseable
        System.out.println("-------------------------------");


        team.teamInfo();
        System.out.println("-------------------------------");

        c_hard.doit(team);
        team.teamResult();
        System.out.println("-------------------------------");

        team.goToCource(c_light);
        team.teamResult();
        System.out.println("-------------------------------");

    }
}
