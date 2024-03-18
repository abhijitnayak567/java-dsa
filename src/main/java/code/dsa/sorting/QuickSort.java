package code.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 16, 2, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) start++;

            while (arr[end] > pivot) end--;

            if (start <= end) {
                if (start != end) {
                    arr[start] = arr[start] + arr[end];
                    arr[end] = arr[start] - arr[end];
                    arr[start] = arr[start] - arr[end];
                }
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
