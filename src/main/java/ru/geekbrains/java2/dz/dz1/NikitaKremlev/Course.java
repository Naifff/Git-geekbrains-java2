package ru.geekbrains.java2.dz.dz1.NikitaKremlev;

/**
 * Класс реализует полосу препядствий.
 * @author Nikita Kremlev
 */
public class Course {
    private static int counter = 0;
    private int id;

    private String courseName;
    private Obstacle[] obstacles;

    public Course() {
        this.obstacles = new Obstacle[4];
        for (int i = 0; i < 4; i++) {
            this.obstacles[i] = new Obstacle();
        }
        this.id = ++counter;
        this.courseName = "полоса препядствий " + id;
    }
    public Course(int countObstacle) {
        this.obstacles = new Obstacle[countObstacle];
        for (int i = 0; i < countObstacle; i++) {
            this.obstacles[i] = new Obstacle();
        }
        this.id = ++counter;
        this.courseName = "полоса препядствий " + id;
    }
    public Course(String courseName, int countObstacle) {
        this(countObstacle);
        this.courseName = courseName;
    }

    /**
     * Дает данные о названии полосы препядствия.
     * @return String параметр, название полосы препядствия.
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * Устанавливает данные о названии полосы препядствия.
     * @param courseName String параметр, название полосы препядствия.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Дает данные о списке препядствий в полосе.
     * @return массив Obstacle[] параметров, список препядствий в полосе.
     */
    public Obstacle[] getObstacles() {
        return obstacles;
    }
    /**
     * Устанавливает данные о списке препядствий в полосе.
     * @param obstacles массив Obstacle[] параметров, список препядствий в полосе.
     */
    public void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * Метод проверяет прошла команда препядстиве или нет.
     * Если команда прошла препядствие, то в консоли выводится информация б этом
     * и наоборот.
     * @param team Team параметр, команда, которая проходит данную полосу препядствий.
     */
    public void doIt(Team team) {
        int sumObstacle = 0;
        int sumTeam = 0;
        for (int i = 0; i < obstacles.length; i++) {
            sumObstacle += obstacles[i].getComplexity();
        }

        for (int i = 0; i < team.getMembers().length; i++) {
            sumTeam += team.getMembers()[i].getEndurance();
        }

        if (sumTeam > sumObstacle) {
            System.out.println("Команда \"" + team.getTeamName() + "\" прошла полосу препядствий \"" + this.courseName + "\".");
        } else {
            System.out.println("Команда \"" + team.getTeamName() + "\" не прошла полосу препядствий \"" + this.courseName + "\".");
        }
    }

    /**
     * Данный метод выводит в консоль информацию о полосе препядствий.
     * Названия препядствий, их сложность и в конце их сумарную сложность.
     */
    public void showResults() {
        int sumObstacle = 0;
        System.out.println("Характеристики полосы препядствий \"" + this.courseName + "\":");
        for (int i = 0; i < obstacles.length; i++) {
            System.out.println(obstacles[i].getObstacleName() + " имеет сложность " + obstacles[i].getComplexity() + " единиц.");
            sumObstacle += obstacles[i].getComplexity();
        }
        System.out.println("Общая сложность полосы препядствий: " + sumObstacle);
        System.out.println();
    }
}
