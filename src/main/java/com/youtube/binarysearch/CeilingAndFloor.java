package com.youtube.binarysearch;

public class CeilingAndFloor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 14, 16, 18};
        System.out.println("ceiling index: " + findCeiling(arr, 15));
        System.out.println("floor index: " + findFloor(arr, 15));
        System.out.println("ceiling index: " + findCeiling(arr, -1));
        System.out.println("floor index: " + findFloor(arr, -1));
        System.out.println("ceiling index: " + findCeiling(arr, 1));
        System.out.println("floor index: " + findFloor(arr, 1));
        System.out.println("ceiling index: " + findCeiling(arr, 13));
        System.out.println("floor index: " + findFloor(arr, 13));
        System.out.println("ceiling index: " + findCeiling(arr, 18));
        System.out.println("floor index: " + findFloor(arr, 18));
        System.out.println("ceiling index: " + findCeiling(arr, 20));
        System.out.println("floor index: " + findFloor(arr, 20));
    }

    private static int findCeiling(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        if (target > arr[endIndex])
            return -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (arr[mid] < target)
                startIndex = mid + 1;
            else if (arr[mid] > target)
                endIndex = mid - 1;
            else
                return mid;
        }
        return startIndex;
    }
    private static int findFloor(int[] arr, int target) {
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
        return endIndex;
    }
}
