package com.chenhaibo.util;

/**
 * @Author: chenhaibo
 * @Description:
 * @Date: Created in 16:05 2018/7/18
 */
public class BubbleSortDemo {

    public static void Swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 简单冒泡排序
     *
     * @param a
     * @param n
     */
    public static void BubbleSort(int[] a, int n) {
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    Swap(a, i, i + 1);
                }
            }
        }
    }

    /**
     * 鸡尾酒冒泡排序
     *
     * @param a
     * @param n
     */
    public static void CocktailSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    Swap(a, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i - 1] > a[i]) {
                    Swap(a, i - 1, i);
                }
            }
            left++;
        }
    }

    /**
     * 选择排序
     *
     * @param a
     * @param n
     */
    public static void SelectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                Swap(a, min, i);
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     * @param n
     */
    public static void InsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int get = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > get) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = get;
        }
    }

    /**
     * 快速排序 - 划分函数
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int Partition(int[] a, int left, int right) {
        int pivot = a[right];
        int tail = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] <= pivot) {
                Swap(a, ++tail, i);
            }
        }
        Swap(a, tail + 1, right);
        return tail + 1;
    }

    /**
     * 快速排序
     *
     * @param a
     * @param left
     * @param right
     */
    public static void QuickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot_index = Partition(a, left, right);
        QuickSort(a, left, pivot_index - 1);
        QuickSort(a, pivot_index + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
        /*BubbleSort(a, a.length);
        System.out.println("冒泡排序结果：");*/
        /*CocktailSort(a, a.length);
        System.out.println("鸡尾酒排序结果：");*/
        /*SelectionSort(a, a.length);
        System.out.println("选择排序结果：");*/
        /*InsertionSort(a, a.length);
        System.out.println("插入排序结果：");*/
        QuickSort(a, 0, a.length - 1);
        System.out.println("快速排序结果：");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
