package ru.geekbrains.java2.dz.dz1.NikitaKremlev;

/**
 * Класс реализует команду.
 * @author Nikita Kremlev
 */
public class Team {
    private static int counter = 0;
    private int id;

    /**
     * Название команды.
     */
    private String teamName;
    /**
     * Список членов команды.
     */
    private Member[] members;

    public Team() {
        this.members = new Member[4];
        for (int i = 0; i < 4; i++) {
            this.members[i] = new Member();
        }
        this.id = ++counter;
        this.teamName = "Команда номер " + id;
    }
    public Team(String teamName) {
        this();
        this.teamName = teamName;
    }
    public Team(String teamName, String memberNameOne, String memberNameTwo, String memberNameThree, String  memberNameFour) {
        this.members = new Member[4];
        this.members[0] = new Member(memberNameOne);
        this.members[1] = new Member(memberNameTwo);
        this.members[2] = new Member(memberNameThree);
        this.members[3] = new Member(memberNameFour);
        this.id = ++counter;
        this.teamName = teamName;
    }

    /**
     * Дает данные о названии команды.
     * @return String параметр, название команды.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Устанавливает данные о названии команды
     * @param teamName String параметр, название команды.
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Дает данные о списке членов команды.
     * @return массив Member[] параметров, список членов команды.
     */
    public Member[] getMembers() {
        return members;
    }
    /**
     * Устанавливает данные о списке членов команды.
     * @param members массив Member[] параметров, список членов команды.
     */
    public void setMembers(Member[] members) {
        this.members = members;
    }

    /**
     * Данный метод выводит в консоль информацию о команде.
     * Имена членов команды, их выносливость и в конце их сумарную выносливость.
     */
    public void showResults() {
        int sumTeam = 0;
        System.out.println("Характеристики команды \"" + this.teamName + "\":");
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].getName() + " имеет выносливость " + members[i].getEndurance() + " единиц.");
            sumTeam += members[i].getEndurance();
        }
        System.out.println("Общая сила команды: " + sumTeam);
        System.out.println();
    }
}
