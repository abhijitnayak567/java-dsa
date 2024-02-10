package com.youtube.binarysearch;

public class RotatedArraySearch {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/

    public static void main(String[] args) {
        RotatedArraySearch ras = new RotatedArraySearch();
        System.out.println(ras.findPivot(new int[]{4,5,6,7,0,1,2})); // 3
        System.out.println(ras.binarySearch(new int[]{4,5,6,7}, 6, 0, 3)); // 2
        System.out.println(ras.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(ras.search(new int[]{4,5,6,7,0,1,2}, 2)); // 6
        System.out.println(ras.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(ras.search(new int[]{1}, 0)); // -1
        System.out.println(ras.search(new int[]{1}, 1)); // -0

    }

    private int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot >= 0) {
            if (nums[pivot] == target)
                return pivot;
            return target > nums[0] ? binarySearch(nums, target, 0, pivot-1) : binarySearch(nums, target, pivot +1,
                    nums.length - 1);
//            int index = binarySearch(nums, target, 0, pivot);
//            return index >= 0 ? index : binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[ mid + 1])
                return mid;
            if (mid > start && arr[mid] < arr[mid -1])
                return mid - 1;
            if (arr[mid] < arr[start])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    private int binarySearch(int[] arr, int target, int start, int end) {
        if (end < start)
            return -1;
        int mid = start + (end - start) / 2;
        if (target == arr[mid])
            return mid;
        if(target > arr[mid])
            return binarySearch(arr, target, mid + 1, end);
        else
            return binarySearch(arr, target, start, mid -1);
    }
}
