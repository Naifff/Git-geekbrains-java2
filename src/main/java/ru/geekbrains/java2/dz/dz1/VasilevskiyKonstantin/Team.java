package ru.geekbrains.java2.dz.dz1.VasilevskiyKonstantin;

public class Team {
    private String nameTeam;
    private boolean passed;
    private Player[] players = new Player[4];

    public Team() {
        this.nameTeam = "Lakers";
        passed = true;
        this.players[0] = new Player("Masha", 47);
        this.players[1] = new Player("Sasha", 80);
        this.players[2] = new Player("Pasha", 85);
        this.players[3] = new Player("Dasha", 63);
    }

    public Player[] getTeam() {
        return players;
    }

    public void getinfoTeam() {
        String textInfoTeam, textInfoPlayers;

        textInfoTeam = "Team: " + nameTeam;
        textInfoPlayers = "Players and thei power: ";

        for (Player player:players) {
            textInfoPlayers = textInfoPlayers.concat("\n");
            textInfoPlayers = textInfoPlayers.concat(player.getInfoPlayer());
        }

        System.out.println(textInfoTeam + "\n" + textInfoPlayers);
    }

    public void showResults() {

        String textShowResults = "Team: " + nameTeam + (!passed ? " the losers": " the winners");

        for (Player player:players) {
            textShowResults = textShowResults.concat("\n");
            textShowResults = textShowResults.concat(player.getInfoShowResultPlayer());
        }

        System.out.println(textShowResults);
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
