package ru.geekbrains.java2.dz.dz1.RoumyantsevPA;

import java.util.Random;

public class Course {
    PartOfCourse[] poc = new PartOfCourse[3];

    public Course() {
        Random rnd = new Random();
        for (int i = 0; i < poc.length; i++) {
            switch (i) {
                case 0:
                    poc[i] = new Cross(rnd.nextFloat() + rnd.nextInt(500));
                    break;
                case 1:
                    poc[i] = new Wall(rnd.nextFloat() + rnd.nextInt(2));
                    break;
                default:
                    poc[i] = new Water(rnd.nextFloat() + rnd.nextInt(300));
            }

        }
    }

    public void doIt(Team team) {

        for (TeamMember member : team.t
                ) {
            System.out.println("\n" + member.getClas() + member.getName() + ":");
            for (PartOfCourse barrier : this.poc
                    ) {

                barrier.doIt((member));
                if (!member.isOnDistance()) {
                    break;


                }

            }
        }
    }

}
