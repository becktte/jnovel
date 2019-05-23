package com.umbrella.jnovel.web.app;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/4/18
 * @Version 1.0
 **/
public class Application2 {
    public static void main(String[] args) {
        Scanner scannerOne = new Scanner(System.in);
        Scanner scannerTwo = new Scanner(System.in);
        String[] date = scannerOne.nextLine().split("\\s");
        String word = scannerTwo.nextLine();

        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);

        String[] arrayOne = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] arrayTwo = {"J", "K", "L", "M", "N", "O", "P", "Q", "R"};
        String[] arrayThree = {"S", "T", "U", "V", "W", "X", "Y", "Z", " "};
        String[][] arrays = {arrayOne, arrayTwo, arrayThree};

        //先将数组内的字母移动day - 1次
        for (int i = 0; i < day - 1; i++) {
            String arrayOneFirst = arrayOne[0];
            for (int j = 0; j < arrayOne.length; j++) {
                if (j == arrayOne.length - 1) {
                    arrayOne[j] = arrayOneFirst;
                } else {
                    arrayOne[j] = arrayOne[j + 1];
                }
            }
            String arrayTwoFirst = arrayTwo[0];
            for (int j = 0; j < arrayTwo.length; j++) {
                if (j == arrayTwo.length - 1) {
                    arrayTwo[j] = arrayTwoFirst;
                } else {
                    arrayTwo[j] = arrayTwo[j + 1];
                }
            }
            String arrayThreeFirst = arrayThree[0];
            for (int j = 0; j < arrayThree.length; j++) {
                if (j == arrayThree.length - 1) {
                    arrayThree[j] = arrayThreeFirst;
                } else {
                    arrayThree[j] = arrayThree[j + 1];
                }
            }
        }

        //然后把数组内的字母组合移动month - 1 次
        for (int i = 0; i < month - 1; i++) {
            String[] arraysFirst = arrays[0];
            for (int j= 0; j < arrays.length; j++) {
                if (j == arrays.length - 1) {
                    arrays[j] = arraysFirst;
                } else {
                    arrays[j] = arrays[j + 1];
                }
            }
        }
        String[] words = word.split("");
        for (String string : words) {
            for (int i = 0; i < arrays.length; i++) {
                for (int j = 0; j < arrays[i].length; j++) {
                    if (string.equals(arrays[i][j])) {
                        System.out.print((i + 1) + "" + (j + 1) + " ");
                    }
                }
            }
        }



    }
}
