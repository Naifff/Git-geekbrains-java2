package ru.geekbrains.java2.dz.dz7.AlinaZhirova.server;

import java.util.ArrayList;

public class BaseAuthService implements AuthService{

    private class Entry{
        private String login;
        private String pass;
        private String nick;

        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }


    private ArrayList<Entry> entries;

    public BaseAuthService() {
        entries = new ArrayList<Entry>();
        entries.add(new Entry("ivanov", "1234", "ivan1986"));
        entries.add(new Entry("belova", "qwerty", "belka_19"));
        entries.add(new Entry("petrov", "24_10_1990", "petrov_vodkin"));
    }


    @Override
    public void start() {
    }


    @Override
    public String getNickByLoginPass(String login, String pass) {
        for (Entry o: entries) {
            if (o.login.equals(login) && o.pass.equals(pass)) {
                return o.nick;
            }
        }
        return null;
    }
    

    @Override
    public void stop() {
    }


}
