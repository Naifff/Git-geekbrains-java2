package ru.geekbrains.java2.dz.dz3.KrivonosovAlexey;

import java.util.Comparator;

public class Passenger {
    private String passengerName;
    private int documentNumber;

    public Passenger(String passengerName, int documentNumber) {
        this.passengerName = passengerName;
        this.documentNumber = documentNumber;
    }


    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNunber) {
        this.documentNumber = documentNunber;
    }


    public static final Comparator<Passenger> COMPARE_BY_NAME = new Comparator<Passenger>() {
        @Override
        public int compare(Passenger o1, Passenger o2) {
            return o1.getPassengerName().compareTo(o2.getPassengerName());
        }
    };
}
