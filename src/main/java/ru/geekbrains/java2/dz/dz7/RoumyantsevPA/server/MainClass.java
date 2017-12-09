package ru.geekbrains.java2.dz.dz7.RoumyantsevPA.server;
public class MainClass {
    public static void main(String[] args) {
        // MyServer w = new MyServer();
        //   System.out.println("Gfhjkm17!@#".hashCode());
        String w = "@root heya";
        System.out.println(w.indexOf('@'));
        char[] wChar=new char[w.length()];
        char[] login2 =new char[w.length()];
        char[] msg = new    char[w.length()];
        wChar=w.toCharArray();
//        try {
//            System.out.println(w);
//            System.out.println(w.length());
//            System.out.println();
//            System.out.println(wChar);
//            System.out.println(wChar.length);
            System.arraycopy(wChar, 1, login2, 0, w.indexOf(' '));
            System.out.println(login2);
           // System.out.println(login2.toString());

            //System.out.println();
           // System.out.println("wChar="+wChar+" w.indexOf(' ')="+(w.indexOf(' '))+" msg="+msg+" wChar.length="+wChar.length-);
            System.arraycopy(wChar, w.indexOf(' ')+1, msg, 0, wChar.length-w.indexOf(' ')-1);

            System.out.println(msg);
//        }catch (Exception e){}
        String s1=new String(login2).trim();
        String s2=new String(msg).trim();
        System.out.println();
        System.out.println(s1+"\t"+ s1.length());
        System.out.println(s2+"\t"+s2.length());


    }
}