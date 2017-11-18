package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

public class Team {
    public TeamMember[] t = new TeamMember[4];

    public Team() {
        for (int i = 0; i < t.length; i++) {
            switch (i) {
                case 0:
                    t[i] = new Cat("Барсик");
                    break;
                case 1:
                    t[i] = new Dog("Тузик");
                    break;
                case 2:
                    t[i] = new Horse("Пегас");
                    break;
                default:
                    t[i] = new Human("Игорь");
            }

        }
    }

    public void showResults() {
        System.out.println("\n \nРезультаты:");
        for (int i = 0; i < t.length; i++) {
            if (t[i].isOnDistance()) {
                System.out.println(t[i].getClas() + t[i].getName() + " - PASS");
            } else {
                System.out.println(t[i].getClas() + t[i].getName() + " - FAILED");
            }


        }
    }
}
