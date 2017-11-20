package ru.geekbrains.java2.dz.dz1.KrivonosovAlexey;

public class Team {
    private String teamName;
    private int numberOfSportsmans;
    protected boolean checkCourse;
    Sportsman [] sportsmansBlank;
    protected int [] results;

    public Team(String teamName, int numberOfSportsmans) {
        this.teamName = teamName;
        this.checkCourse = false;
        this.numberOfSportsmans = numberOfSportsmans;
        this.results = new int[numberOfSportsmans];
        this.sportsmansBlank = new Sportsman [numberOfSportsmans];
        for (int i = 0; i < numberOfSportsmans; i++) {
            sportsmansBlank[i] = new Sportsman(Integer.toString(i));
            results[i] = 0;
        }
    }

    public void showResults(){
        int flag = 1;
        System.out.println("#####Результаты#####");
        if (checkCourse == true){
            for (int i = 0; i < numberOfSportsmans; i++) {
                if (results[i] == 0){
                    System.out.println("Спортсмен " + sportsmansBlank[i].getName() + " провалил испытание");
                    flag = 0;
                }
            }
            if (flag == 1){
                System.out.println("Команда справилась с испытанием");
            } else System.out.println("Команда не справилась с испытанием");
        } else System.out.println("Команда не проходила испытание");
    }

    public int getNumberOfSportsmans() {
        return numberOfSportsmans;
    }

    public String getTeamName() {
        return teamName;
    }

    public void getTeamInfo(){
        System.out.println("#####Информация о команде#####");
        System.out.println("Имя команды: " + teamName);
        System.out.println("Количество спортсменов: " + numberOfSportsmans);
        for (int i = 0; i < numberOfSportsmans; i++) {
            sportsmansBlank[i].getInfo();
        }
    }



}
