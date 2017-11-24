package ru.geekbrains.java2.dz.dz2.BelomestsevOleg;

public class MyArraySizeException extends IllegalArgumentException {
    String s;
    @Override
    public String toString() {
        return super.toString()+s;
    }
    public MyArraySizeException(int i, int j){
        s = " Error: Expected array size:["+i+"]"+"["+j+"]";
    }
}
