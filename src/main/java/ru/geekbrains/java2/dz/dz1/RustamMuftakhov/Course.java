package ru.geekbrains.java2.dz.dz1.RustamMuftakhov;

public class Course {

    Obstacle run = new Obstacle("Run", 1000);
    Obstacle jump = new Obstacle("Jump", 20);
    Obstacle swim = new Obstacle("Swim", 200);


    public Course(){

        Obstacle[] course = new Obstacle[3];
        course[0] = run;
        course[1] = jump;
        course[2] = swim;

    }

    public void runCourse(Team team){

        for (int i = 0; i < 4; i++) {

            team.team[i].action(swim.obstacleParameter, team.team[i].enduranceSwim, "swimming");
            team.team[i].action(jump.obstacleParameter, team.team[i].enduranceJump, "jumping");
            team.team[i].action(run.obstacleParameter, team.team[i].enduranceRun, "running");

        }

    }

}
