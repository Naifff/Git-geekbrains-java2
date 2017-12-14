package ru.geekbrains.java2.dz.dz4.RoumyantsevPA;

public class Mail {
    public static void main(String[] args) {
        long max=10000000000L;
        for(;;){
        long t1 = System.currentTimeMillis();
        int b = 0;
        for (long i = 0L; i < max; i++) {
            if (b > 0) b = 0;
        }
        long t2 = System.currentTimeMillis();
//        System.out.println("Прошло времени: " + (t2 - t1) + "мс.");
        long t11 = System.currentTimeMillis();
        for (long i = 0L; i < max; i++) b = 0;
        long t22 = System.currentTimeMillis();
//        System.out.println("Прошло времени: " + (t22 - t11) + "мс.");
       // if(t22-t11==t2-t1||max>2000000000){
            System.out.println("Прошло времени: " + (t2 - t1) + "мс."+"Прошло времени: " + (t22 - t11) + "мс.");
             break;
            // }
           // max+=100000;
            //System.out.println(max);

    }
        //System.out.println("fin= "+max);

    }
}