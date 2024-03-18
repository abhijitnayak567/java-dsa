package code.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 16, 2, 9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{12, 5, 8, 16, 2, 9};
        selectionSortRe(arr, 0, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
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

    private static void selectionSortRe(int[] arr, int maxIndex, int curIndex, int lastIndex) {
        if (lastIndex == 0) return;

        if (curIndex <= lastIndex) {
            if (arr[curIndex] > arr[maxIndex])
                maxIndex = curIndex;
            selectionSortRe(arr, maxIndex, curIndex + 1, lastIndex);
        } else {
            if (maxIndex != lastIndex) {
                arr[lastIndex] = arr[maxIndex] + arr[lastIndex];
                arr[maxIndex] = arr[lastIndex] - arr[maxIndex];
                arr[lastIndex] = arr[lastIndex] - arr[maxIndex];
            }
            selectionSortRe(arr, 0, 0, lastIndex - 1);
        }
    }
}