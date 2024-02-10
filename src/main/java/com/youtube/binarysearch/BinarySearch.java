package com.youtube.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-14, -9, -2, 0, 1, 5, 9, 12, 15, 18, 22, 33, 38};
        System.out.println("target index: " + binarySearch(arr, 15));
        System.out.println("target index: " + binarySearch(arr, 33));
        System.out.println("target index: " + binarySearch(arr, -14));
        System.out.println("target index: " + binarySearch(arr, 1));
        System.out.println("target index: " + binarySearch(arr, 13));
        System.out.println("target index: " + binarySearch(arr, 20));
    }

    private static int binarySearch(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (arr[mid] < target)
                startIndex = mid + 1;
            else if (arr[mid] > target)
                endIndex = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
