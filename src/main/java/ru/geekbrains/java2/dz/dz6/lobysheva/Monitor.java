package ru.geekbrains.java2.dz.dz6.lobysheva;

/*
 * Created by Oxana Lobysheva on 07/12/2017.
 */

public class Monitor {

    private String applicationStatus;

    public synchronized String getApplicationStatus() {
        return applicationStatus;
    }


    public synchronized void setActiveStatus() {
        this.applicationStatus = "Active";
    }


    public synchronized void setClosedStatus() {
        this.applicationStatus = "Closed";
    }
}
