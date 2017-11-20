package ru.geekbrains.java2.dz.dz1.FedulovMS.AnimalRaces;

public class Course {
    protected final int TRACK_LENGTH_LIMIT = 10;
    protected Barrier[] track;
    protected int trackLength;

    public Course() {
        this.track = new Barrier[this.TRACK_LENGTH_LIMIT];
        this.trackLength = 0;
    }

    public Course(Barrier[] track) {
        if (track.length <= this.TRACK_LENGTH_LIMIT){
            this.track = track;
            this.trackLength = track.length;
        } else {
            System.out.printf("Слишком много препятствий, только первые %d использованы.\n", this.TRACK_LENGTH_LIMIT);
            this.trackLength = this.TRACK_LENGTH_LIMIT;
            this.track = new Barrier[this.TRACK_LENGTH_LIMIT];
            for(int i=0; i<this.TRACK_LENGTH_LIMIT; i++){
                this.track[i] = track[i];
            }
        }
    }

    public void addStage(Barrier b){
        if (this.trackLength == this.TRACK_LENGTH_LIMIT){
            System.out.println("Достигнута максимальная длина трассы.");
        } else {
            this.track[this.trackLength] = b;
            this.trackLength++;
        }
    }

    public int getSize(){
        return this.trackLength;
    }

    public void printInfo(){
        if (this.trackLength == 0){
            System.out.println("Трасса не создана.");
        } else {
            System.out.println("Этапы трассы:");
            for (int i=0; i<this.trackLength; i++) {
                System.out.println("    " + this.track[i]);
            }
        }
    }

    public void doIt(Team team){
        System.out.println("Начинается забег!");
        for (int i=0; i<this.trackLength; i++){
            System.out.println("Препятствие " + (i+1) + " (" +this.track[i]+ "):");
            team.runStage(this.track[i]);
        }
    }
}
