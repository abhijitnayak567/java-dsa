package com.youtube.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 16, 2, 9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        int a =10;
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - i - 1;
            int maxIndex = 0;
            for (int j = 1; j <= lastIndex; j++)
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            if (maxIndex != lastIndex) {
                arr[lastIndex] = arr[lastIndex] + arr[maxIndex];
                arr[maxIndex] = arr[lastIndex] - arr[maxIndex];
                arr[lastIndex] = arr[lastIndex] - arr[maxIndex];
            }
        }
    }
}