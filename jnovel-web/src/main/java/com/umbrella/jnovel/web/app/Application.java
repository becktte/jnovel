package com.umbrella.jnovel.web.app;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/4/18
 * @Version 1.0
 **/
public class Application {
    public static void main(String[] args) {
        Scanner scannerOne = new Scanner(System.in);
        Scanner scannerTwo = new Scanner(System.in);

        int total = scannerOne.nextInt();
        String[] strings = scannerTwo.nextLine().split("\\s");
        int[] priceArr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            priceArr[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(priceArr);
        int totalPrice = 0;
        for (int i = 0; i < priceArr.length; i++) {
            int price = priceArr[i];
            totalPrice += price;
            if (totalPrice > total) {
                totalPrice -= price;
            }
        }
        System.out.println(totalPrice);

    }
}
