package com.umbrella.jnovel.common.sort;

/**
 * @Description 冒泡排序
 * @Author becktte
 * @Date 2019/9/19
 * @Version 1.0
 **/
public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 9, 1, 3, 4, 3, 2};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
