package ru.geekbrains.java2.dz.dz2.lobysheva;

/*
 * Created by Oxana Lobysheva on 20/11/2017.
 */

public class Main {

    public static void main(String[] arg) {

        String[][] myArray1 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] myArray2 = new String[][]{
                {"1", "2", "", "4"},
                {null, "2", "s", "4"},
                {"1", "-", "3", "fff"}
        };


        System.out.println("\n------- POSITIVE CASES ---------\n");

        printArrayLength(myArray1, 4);
        System.out.println("Sum of elements = " + sumArrayElements(myArray1));

        System.out.println("\n------- NEGATIVE CASES ---------\n");

        printArrayLength(myArray2, 4);
        System.out.println("Sum of elements = " + sumArrayElements(myArray2));

    }


    private static void printArrayLength(String[][] myArray, int controlSize) {
        try {
            if (myArray.length == controlSize) {
                System.out.println("myArray.length = " + myArray.length);
            } else {
                throw new MyArraySizeException("myArray.length <> " + controlSize);
            }
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i].length == controlSize) {
                    System.out.println("myArray[" + i + "].length = " + myArray[i].length);
                } else {
                    throw new MyArraySizeException("myArray[" + i + "].length <> " + controlSize);
                }
            }
        } catch (MyArraySizeException e) {
            e.printMyMessage();
        }
    }

    private static int sumArrayElements(String[][] myArray) {
        int sumElements = 0;
        String exceptions = "";
        try {
            for (int i = 0; i < myArray.length; i++) {
                for (int k = 0; k < myArray[i].length; k++) {
                    try {
                        sumElements += Integer.parseInt(myArray[i][k]);
                    } catch (NumberFormatException e) {
                        exceptions += "myArray[" + i + "][" + k + "]: " + myArray[i][k] + " is not integer;\n";
                    }
                }
            }
            if (!exceptions.isEmpty()) throw new MyArrayDataException(exceptions);
        } catch (MyArrayDataException e) {
            e.printMyMessage();
        }
        return sumElements;
    }

}
