package ru.geekbrains.java2.dz.dz1.RonaldKirka;

public class Team {
    String name1;
    String name2;
    String name3;
    String name4;
    String teamName;
    static String[] Contestants = new String[4];



    public Team(String teamName, String name1, String name2, String name3, String name4){
        this.teamName = teamName;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;


        Contestants[0] = name1;
        Contestants[1] = name2;
        Contestants[2] = name3;
        Contestants[3] = name4;

        int sdg = 3;

    }

    void AllInfo() {
        System.out.println("Участники: ");
        for (int i = 0; i < Contestants.length; i++) System.out.println(Contestants[i]);
    }

    void showResults(){
        for (int i = 0; i < Contestants.length; i++) {
            if(Course.finish[i] == true){
                System.out.println(Contestants[i] + " прошел полосу препядствий.");
            }
            else{
                System.out.println(Contestants[i] + " не прошел полосу препядствий.");
            }
        }
    }



}
