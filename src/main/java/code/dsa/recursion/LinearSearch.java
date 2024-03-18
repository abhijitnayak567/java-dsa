package code.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(findAllIndexes(new int[]{5, 7, 2, 9, 10, 9, 8, 9, 15, 23}, 9, 0));
        System.out.println(findAllIndexes(new int[]{5, 7, 2, 9, 10, 9, 8, 9, 15, 23}, 5, 0));
        System.out.println(findAllIndexes(new int[]{5, 7, 2, 9, 10, 9, 8, 9, 15, 23}, 22, 0));
    }

    private static List<Integer> findAllIndexes(int[] arr, int tgt, int index) {
        if (index == arr.length) return new ArrayList<>();

        List<Integer> res = findAllIndexes(arr, tgt, index + 1);

        if (arr[index] == tgt) res.add(0, index);

        return res;
    }
}
