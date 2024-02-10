package com.youtube.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 16, 2, 9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j] + arr[j - 1];
                    arr[j - 1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j - 1];
                } else
                    break;
            }
        }
    }
}
