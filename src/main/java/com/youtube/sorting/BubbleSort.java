package com.youtube.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 16, 2, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean hasSwapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    hasSwapped = true;
                    arr[j] = arr[j] + arr[j - 1];
                    arr[j - 1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j - 1];
                }
            }
            if (!hasSwapped)
                break;
        }
    }
}
