package com.chenhaibo.util;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 19:53 2018/8/14
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * @param d     位数
     * @param array
     */
    private static void radixSort(int d, int[] array) {
        //代表位数对应的数：1,10,100...
        int n = 1;
        //保存每一位排序后的结果用于下一位的排序输入
        int k = 0;
        //排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[][] bucket = new int[10][array.length];
        //用于保存每个桶里有多少个数字 ,最多为输入数组长度
        int[] num = new int[array.length];
        while (n <= d) {
            //将数组array里的每个数字放在相应的桶里
            for (int e : array) {
                int digit = (e / n) % 10;
                bucket[digit][num[digit]] = e;
                num[digit]++;
            }
            //将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            for (int i = 0; i < array.length; i++) {
                //这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                if (num[i] != 0) {
                    for (int j = 0; j < num[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                //将桶里计数器置0，用于下一次位排序
                num[i] = 0;
            }
            n *= 10;
            //将k置0，用于下一轮保存位排序结果
            k = 0;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 4};
        bubbleSort(array);
        //radixSort(array.length, array);
    }
}
