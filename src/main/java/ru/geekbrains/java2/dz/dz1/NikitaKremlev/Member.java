package ru.geekbrains.java2.dz.dz1.NikitaKremlev;

/**
 * Класс реализует члена команды.
 * @author Nikita Kremlev
 */
public class Member {
    private static final int MIN_ENDURANCE = 1;
    private static final int MAX_ENDURANCE = 10;

    private static int counter = 0;
    private int id;

    /**
     * Имя члена команды.
     */
    private String name;
    /**
     * Выносливость члена команды.
     */
    private int endurance;

    public Member() {
        this.id = ++counter;
        this.name = "Член команды " + id;
        this.endurance = MIN_ENDURANCE + (int)(Math.random() * MAX_ENDURANCE);
    }
    public Member(String name) {
        this.name = name;
        this.endurance = MIN_ENDURANCE + (int)(Math.random() * MAX_ENDURANCE);
        this.id = ++counter;
    }
    public Member(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
    }

    /**
     * Дает данные о имени члена команды.
     * @return возвращает String параметр, имя члена команды.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает данные о имени члена команды.
     * @param name String параметр, имя члена команды.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Дает данные о выносливости члена команды.
     * @return возвращает int параметр, выносливость члена команды.
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Устанавливает данные о выносливости члена команды.
     * @param endurance int параметр, выносливость члена команды.
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
}
