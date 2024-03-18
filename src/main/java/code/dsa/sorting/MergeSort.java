package code.dsa.sorting;

import javax.xml.stream.util.XMLEventAllocator;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 16, 2, 9};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] newArr = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j])
                newArr[k++] = arr1[i++];
            else
                newArr[k++] = arr2[j++];
        }

        while (i < arr1.length)
            newArr[k++] = arr1[i++];

        while (j < arr2.length)
            newArr[k++] = arr2[j++];

        return newArr;
    }
}
