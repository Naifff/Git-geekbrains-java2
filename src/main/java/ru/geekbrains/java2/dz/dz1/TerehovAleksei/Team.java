package ru.geekbrains.java2.dz.dz1.TerehovAleksei;

public class Team {
    private String name;
    private Animal[] animals;

    public Animal[] getAnimals() {
        return animals;
    }

    public Team(String name, Animal[] animals) {
        this.name = name;
        this.animals = animals;
    }

    public void showResults(){
        System.out.println("К финишу дошли:");

        for (int i = 0; i < animals.length; i++){
            if (animals[i].isOnDistance()){
                animals[i].getName();
            }
        }
    }

    public void getAll(){
        System.out.println("Состав участников:");

        for (int i = 0; i < animals.length; i++){
                animals[i].getName();
        }
    }
}
