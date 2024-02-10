package com.youtube.binarysearch;

public class NextGreatestLetter {
    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int startIndex = 0;
        int endIndex = letters.length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (target < letters[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return letters[startIndex % letters.length];
    }
}
