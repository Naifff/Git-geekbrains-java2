package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

public class Cource {

    Barier[] bariers;

    public Cource(Barier[] bariers) {
        this.bariers = bariers;
    }

    public void dolt(Team team){
        Animal[] animals = team.getAnimals();
        for (int i = 0; i < bariers.length; i++){
            bariers[i].getInfo();
            for (int j = 0; j < animals.length; j++){
                if (animals[j].isOnDistance()){
                    bariers[i].canBarier(animals[j]);
                }
            }
        }
    }
}
