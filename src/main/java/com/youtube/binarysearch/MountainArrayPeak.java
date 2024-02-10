package com.youtube.binarysearch;

public class MountainArrayPeak {
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // https://leetcode.com/problems/find-peak-element/description/
    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
