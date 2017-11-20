package ru.geekbrains.java2.dz.dz1.NikitaKremlev;

/**
 * Класс реализует препядствие.
 * @author Nikita Kremlev
 */
public class Obstacle {
    private static final int MIN_COMPLEXITY = 1;
    private static final int MAX_COMPLEXITY = 5;

    private static int counter = 0;
    private int id;

    /**
     * Название препядствия.
     */
    private String obstacleName;
    /**
     * Сложность препядствия.
     */
    private int complexity;

    public Obstacle() {
        this.id = ++counter;
        this.obstacleName = "Препядствие " + id;
        this.complexity = MIN_COMPLEXITY + (int)(Math.random() * MAX_COMPLEXITY);
    }
    public Obstacle(String obstacleName) {
        this.obstacleName = obstacleName;
        this.complexity = MIN_COMPLEXITY + (int)(Math.random() * MAX_COMPLEXITY);
        this.id = ++counter;
    }
    public Obstacle(String obstacleName, int complexity) {
        this.obstacleName = obstacleName;
        this.complexity = complexity;
        this.id = ++counter;
    }

    /**
     * Дает данные о названии препядствия.
     * @return String параметр, название препядствия.
     */
    public String getObstacleName() {
        return obstacleName;
    }
    /**
     * Устанавливает данные о названии препядствия.
     * @param obstacleName String параметр, название препядствия.
     */
    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    /**
     * Дает данные о сложности препядствия.
     * @return int параметр, сложность препядствия.
     */
    public int getComplexity() {
        return complexity;
    }

    /**
     * Устанавливает данные о сложности препядствия.
     * @param complexity int параметр, сложность препядствия.
     */
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
}
