package ru.geekbrains.java2.dz.dz1.VasilevskiyKonstantin;

public class Course {
    private Barrier[] barriers = new Barrier[3];

    public Course() {
        barriers[0] = new Barrier("Run", 25);
        barriers[1] = new Barrier("Jump", 10);
        barriers[2] = new Barrier("Swim", 35);
    }

    public void Dolt(Team team) {
        Player[] players = team.getTeam();
        for (Player player:players) {
            Go(player);

            if(!player.isPassed()) {
                team.setPassed(false);
            }
        }
    }

    private void Go(Player player) {
        int power = player.getPower();

        for (Barrier barrier:barriers) {
            power = power - barrier.getForce();

            if(power < 0) {
                player.setPower(0);
                player.setPassed(false);
                player.setBarrier(new Barrier(barrier.getName(), -power));
                break;
            }
        }
        player.setPower(power);
    }

}
