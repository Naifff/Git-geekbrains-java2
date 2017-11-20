package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Team {
    protected final int TEAM_SIZE_LIMIT = 10;
    protected Animal[] team;
    protected int teamSize;
    protected int[] results; //Номер этапа, на котором участник выбыл
    protected boolean[] onDistance;
    protected int raceLength = 0;

    public Team() {
        this.team = new Animal[this.TEAM_SIZE_LIMIT];
        this.results = new int[this.TEAM_SIZE_LIMIT];
        this.onDistance = new boolean[this.TEAM_SIZE_LIMIT];
        this.teamSize = 0;
        for (int i=0; i<this.TEAM_SIZE_LIMIT; i++) {
            results[i] = 0;
            onDistance[i] = true;
        }
    }

    public Team(Animal[] team) {
        this.team = new Animal[this.TEAM_SIZE_LIMIT];
        this.results = new int[this.TEAM_SIZE_LIMIT];
        this.teamSize = Math.min(this.TEAM_SIZE_LIMIT, team.length);

        if (team.length > this.TEAM_SIZE_LIMIT) {
            System.out.printf("Cлишком много участников, только первые %d использованы.\n", this.TEAM_SIZE_LIMIT);
        }

        for (int i=0; i<this.teamSize; i++) {
            this.team[i] = team[i];
        }

        for (int i=0; i<this.TEAM_SIZE_LIMIT; i++) {
            results[i] = 1;
        }
    }

    public void addMember(Animal a){
        if (this.teamSize == this.TEAM_SIZE_LIMIT){
            System.out.println("Достигнуто максимальное количество участников.");
        } else {
            this.team[this.teamSize] = a;
            this.teamSize++;
        }
    }

    public int getSize(){
        return this.teamSize;
    }

    public void printInfo(){
        if (this.teamSize == 0){
            System.out.println("В команде нет участников.");
        } else {
            System.out.println("Участники команды:");
            for (int i=0; i<this.teamSize; i++){
                //System.out.println("    "+this.team[i]);
                this.team[i].printInfo();
            }
        }
    }

    public void runStage(Barrier b){
        for (int i=0; i<teamSize; i++) {
            if (this.onDistance[i]){
                System.out.print("    "+this.team[i] + " ");
                if (this.team[i].cross(b)){
                    this.results[i]++;
                    System.out.println(" и продолжает забег.");
                } else {
                    this.onDistance[i] = false;
                    System.out.println(" и сходит с дистанции.");
                }
            }
        }
        this.raceLength++;
    }

    public void showResults(){
        int longestTitle = 0;

        if (this.raceLength == 0) {
            System.out.println("Нет доступных результатов.");
            return;
        }

        for (int i=0; i<this.teamSize; i++){
            if (this.team[i].toString().length() > longestTitle) {
                longestTitle = this.team[i].toString().length();
            }
        }

        System.out.println("Результаты забега:");

        for (int i=0; i<longestTitle; i++){
            System.out.print(" ");
        }

        System.out.print(" |");

        for (int i=0; i<this.raceLength; i++){
            System.out.print(" " + (i+1));
        }

        System.out.println("|");

        for (int i=0; i<this.teamSize; i++) {
            System.out.print(this.team[i]);
            for (int j = this.team[i].toString().length(); j < longestTitle; j++) {
                System.out.print(" ");
            }

            System.out.print(" |");
            for (int j = 0; j < this.raceLength; j++) {
                if (j < this.results[i]){
                    System.out.print("--");
                }

                if (j == this.results[i]){
                    System.out.print("-X");
                }

                if (j > this.results[i]){
                    System.out.print("  ");
                }
            }
            System.out.println("| " + (this.results[i]<this.raceLength?"-":"+"));
        }
    }
}
