package ru.geekbrains.java2.lesson1.inner;


public class Outer {
    class Inner {
        private int innerVar;
        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }
        void innerTest() {
            System.out.println("innerVar: " + innerVar);
            System.out.println("outerVar: " + outerVar);
        }
    }
    private int outerVar;
    public Outer(int outerVar) {
        this.outerVar = outerVar;
    }
    public void outerTest() {
        System.out.println("outerVar: " + outerVar);
// System.out.println("innerVar: " + innerVar); тут ошибка
        Inner io = new Inner(20);
        System.out.println("io.innerVar = " + io.innerVar);
    }

}
