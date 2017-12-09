package ru.geekbrains.java2.dz.dz6.YagudinAlexey.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Typing{

    protected Socket s;
    protected PrintWriter pw;
    protected Scanner in;
    protected Scanner sc;
    protected String name;
    protected String w;

    public Typing(Socket s, String name) {

        this.name = name;
        sc = new Scanner(System.in);

        try {
            this.s = s;
            pw = new PrintWriter(s.getOutputStream());
            in = new Scanner(s.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



