package ru.geekbrains.java2.dz.dz2.BelomestsevOleg;

public class MyArrayDataException extends IllegalArgumentException {
    String s;
    @Override
    public String toString() {
        return super.toString()+s;
    }
    public MyArrayDataException(int i, int j){
        s = " Error: Expected Integer in:["+i+"]"+"["+j+"]";
    }
}
