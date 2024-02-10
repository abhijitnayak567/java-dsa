package com.youtube.binarysearch;

import java.util.Arrays;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arrAsc = {-14, -9, -2, 0, 1, 5, 9, 12, 15, 18, 22, 33, 38};
        System.out.println("target index: " + binarySearch(arrAsc, 15));
        System.out.println("target index: " + binarySearch(arrAsc, 33));
        System.out.println("target index: " + binarySearch(arrAsc, -14));
        System.out.println("target index: " + binarySearch(arrAsc, 1));
        System.out.println("target index: " + binarySearch(arrAsc, 13));
        System.out.println("target index: " + binarySearch(arrAsc, 20));
        System.out.println();
        int[] arrDsc = {38,33,22,18,15,12,9,5,1,0,-2,-9,-14};
        System.out.println("target index: " + binarySearch(arrDsc, 15));
        System.out.println("target index: " + binarySearch(arrDsc, 33));
        System.out.println("target index: " + binarySearch(arrDsc, -14));
        System.out.println("target index: " + binarySearch(arrDsc, 1));
        System.out.println("target index: " + binarySearch(arrDsc, 13));
        System.out.println("target index: " + binarySearch(arrDsc, 20));
    }

    private static int binarySearch(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        boolean isAsc = arr[startIndex] < arr[endIndex];

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (arr[mid] == target)
                return mid;
            if (isAsc) {
                if (arr[mid] < target)
                    startIndex = mid + 1;
                else
                    endIndex = mid - 1;
            } else {
                if (arr[mid] > target)
                    startIndex = mid + 1;
                else
                    endIndex = mid - 1;
            }
        }
        return -1;
    }
}
