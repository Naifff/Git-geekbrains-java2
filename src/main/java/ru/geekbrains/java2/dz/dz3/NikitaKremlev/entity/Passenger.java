package ru.geekbrains.java2.dz.dz3.NikitaKremlev.entity;

/**
 * Класс реализует Пассажира
 */
public class Passenger {
    private String name;
    private Long passportID;

    public Passenger(String name, Long passportID) {
        this.name = name;
        this.passportID = passportID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getPassportID() {
        return passportID;
    }
    public void setPassportID(Long passportID) {
        this.passportID = passportID;
    }

    public void writeConsole() {
        System.out.println("Пассажир по имени: " + name + ", паспорт: " + passportID);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportID=" + passportID +
                '}';
    }
}
