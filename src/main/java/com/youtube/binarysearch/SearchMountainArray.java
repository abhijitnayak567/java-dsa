package com.youtube.binarysearch;

interface MountainArray {
    int get(int index);
    int length();
}

public class SearchMountainArray {
    // https://leetcode.com/problems/find-in-mountain-array/description/

    /**
     * // This is MountainArrayPeak's API interface.
     * // You should not implement it, or speculate about its implementation
     */
    public int findInMountainArray(int target, MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(mid + 1))
                end = mid;
            else
                start = mid + 1;
        }
        int peak = start;
        if (arr.get(peak) == target)
            return peak;
        start = 0;
        end = peak - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < target)
                start = mid + 1;
            else if (arr.get(mid) > target)
                end = mid - 1;
            else
                return mid;
        }
        start = peak + 1;
        end = arr.length() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < target)
                end = mid - 1;
            else if (arr.get(mid) > target)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
