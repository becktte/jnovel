package com.umbrella.jnovel.common.sort;

/**
 * @Description 选择排序
 * @Author becktte
 * @Date 2019/9/19
 * @Version 1.0
 **/
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i< array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 8, 9, 2, 6, 3, 2};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
