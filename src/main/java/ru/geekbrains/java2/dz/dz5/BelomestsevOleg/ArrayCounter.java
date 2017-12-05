package ru.geekbrains.java2.dz.dz5.BelomestsevOleg;

public class ArrayCounter {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    long a;

    public static void main(String[] args) {
        ArrayCounter arrayCounter = new ArrayCounter();
        arrayCounter.method1();
        arrayCounter.method2();
    }
    public void method1(){
        initArray();
        a = System.currentTimeMillis();
        calcArray(arr,0);
        System.out.println(System.currentTimeMillis()-a);
    }
    public void method2(){
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        initArray();
        a = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr,h,a2,0,h);
        Thread thread1 = new Thread(() -> calcArray(a1,0));
        Thread thread2 = new Thread(() -> calcArray(a2,h));             // Второй поток будет считаться дольше, для увеличения быстродействия его можно разбить на два потока или поменять размеры массивов а1 и а2.
        thread1.start();
        thread2.start();
//        calcArray(a1,0);          //Для последовательного вызова
//        calcArray(a2,h);
        try {
            thread1.join();         //Ждем окончания потоков
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1,0,arr,0,h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis()-a);
    }
    public void calcArray(float[] array, int k){ // Добавим переменную k, и заменим i на k во второй части формулы,
        // что бы значения ячеек после склейки массивов совпадали с массивом arr в первом методе. Это сделано для корректности
        // финального времени, т.к. первая часть массива arr считается примерно на 50% быстрее. Проверить данное утверждение
        // легко, вызвав calcArray(a1,0) и calcArray(a2,h) последовательно. Следовательно время: t(arr)=t(a1)+t(a2).
        for (int i = 0; i < array.length ; i++,k++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
        }
    }
    public void initArray() {
        for (int i = 0; i <size; arr[i++] = 1);
    }
}