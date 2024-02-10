package com.youtube.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastIndex {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 7, 7, 8, 8, 10};
        FindFirstAndLastIndex fli = new FindFirstAndLastIndex();
        System.out.println(Arrays.toString(fli.searchRange(nums, 8)));
        System.out.println(Arrays.toString(fli.searchRange(nums, 6)));
        System.out.println(Arrays.toString(fli.searchRange(nums, 7)));
        System.out.println(Arrays.toString(fli.searchRange(nums, 5)));
        System.out.println(Arrays.toString(fli.searchRange(new int[]{}, 1)));

    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = searchFirstIndex(nums, target, 0, nums.length - 1);
        if (ans[0] != -1)
            ans[1] = searchLastIndex(nums, target, 0, nums.length - 1);
        return ans;
    }

    public int searchFirstIndex(int[] arr, int target, int start, int end) {
        int result = -1;
        if (end < start)
            return result;
        int mid = start + (end - start) / 2;
        if (target < arr[mid])
            return searchFirstIndex(arr, target, start, mid - 1);
        if (target > arr[mid])
            return searchFirstIndex(arr, target, mid + 1, end);
        result = searchFirstIndex(arr, target, start, mid - 1);
        return result < 0 ? mid : result;
    }

    public int searchLastIndex(int[] arr, int target, int start, int end) {
        int result = -1;
        if (end < start)
            return result;
        int mid = start + (end - start) / 2;
        if (target < arr[mid])
            return searchLastIndex(arr, target, start, mid - 1);
        if (target > arr[mid])
            return searchLastIndex(arr, target, mid + 1, end);
        result = searchLastIndex(arr, target, mid + 1, end);
        return result < 0 ? mid : result;
    }
}
