package ru.geekbrains.java2.lesson3;

/**
 * Created by Home-pc on 21.03.2017.
 */
public class Car {
    private String title;
    private int nomer;
    private byte god;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (nomer != car.nomer) return false;
        if (god != car.god) return false;
        return title != null ? title.equals(car.title) : car.title == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + nomer;
        result = 31 * result + (int) god;
        return result;
    }
}
