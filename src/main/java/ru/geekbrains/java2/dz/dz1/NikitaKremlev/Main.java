package ru.geekbrains.java2.dz.dz1.NikitaKremlev;

public class Main {
    public static void main(String[] args) {
        // Описание каждого метода находится в файлах классов.
        Course c = new Course("Канализация", 6); // Создаем полосу препятствий
        Team team = new Team("Черепашки ниндзя", "Леонардо", "Донателла", "Рафаэль", "Микеланджело"); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
        c.showResults();
    }
}
