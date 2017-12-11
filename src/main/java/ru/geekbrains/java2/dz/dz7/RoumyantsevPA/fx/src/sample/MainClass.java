package sample;

public class MainClass {
    public static void main(String[] args) {
        String strA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_";
        //String strA = "abcdefghijklmnopqrstuvwxyz";
        String str = "";
        long t1 = System.currentTimeMillis();
        boolean br = false;
        System.out.println(strA.length());
        int count = -1;
        long t2;
        for (int i = 0; i < strA.length(); i++) {
            if (i % 6 == 0) {
                count++;
                System.out.println(count);
                t2 = System.currentTimeMillis();
                System.out.println("Прошло времени: " + (t2 - t1) + "мс.");
            }
            for (int j = 0; j < strA.length(); j++) {
                for (int a = 0; a < strA.length(); a++) {
                    for (int b = 0; b < strA.length(); b++) {
                        for (int c = 0; c < strA.length(); c++) {
                            for (int d = 0; d < strA.length(); d++) {
                                for (int e = 0; e < strA.length(); e++) {
                                    if (i == 0) {
                                        if (j == 0) {
                                            if (a == 0) {
                                                if (b == 0) {
                                                    if (c == 0) {
                                                        if (d == 0) {
                                                            str = String.valueOf(strA.charAt(e));
                                                        } else
                                                            str = String.valueOf(strA.charAt(d)) + String.valueOf(strA.charAt(e));
                                                    } else
                                                        str = String.valueOf(strA.charAt(c)) + String.valueOf(strA.charAt(d)) + String.valueOf(strA.charAt(e));
                                                } else
                                                    str = String.valueOf(strA.charAt(b)) + String.valueOf(strA.charAt(c)) + String.valueOf(strA.charAt(d)) + String.valueOf(strA.charAt(e));
                                            } else
                                                str = String.valueOf(strA.charAt(a)) + String.valueOf(strA.charAt(b)) + String.valueOf(strA.charAt(c)) + String.valueOf(strA.charAt(d)) + String.valueOf(strA.charAt(e));
                                        } else
                                            str = String.valueOf(strA.charAt(j)) + String.valueOf(strA.charAt(a)) + String.valueOf(strA.charAt(b)) + String.valueOf(strA.charAt(c)) + String.valueOf(strA.charAt(d)) + String.valueOf(strA.charAt(e));
                                    } else
                                        str = String.valueOf(strA.charAt(i)) + String.valueOf(strA.charAt(j)) + String.valueOf(strA.charAt(a)) + String.valueOf(strA.charAt(b)) + String.valueOf(strA.charAt(c)) + String.valueOf(strA.charAt(d)) + String.valueOf(strA.charAt(e));
                                    //System.out.println(str);
                                    if (str.hashCode() == -946852072) br = true;
                                    if (br) break;
                                }
                            }
                            if (br) break;
                        }
                        // str=ii+jj+aa+Character.toChars(b)+"";

                        if (br) break;
                    }
                    if (br) break;
                }

                if (br) break;

            }
            if (br) break;
        }
        System.out.println(str);
        t2 = System.currentTimeMillis();
        System.out.println("Прошло времени: " + (t2 - t1) + "мс.");
    }
}
