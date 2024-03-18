package code.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
        System.out.println(Arrays.toString(intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        final int N = 1001;
        var set = new int [N];

        for (var n : nums1) set[n] = 1;

        int resCount = 0;

        for (var n : nums2)
            if (set[n] == 1) {
                set[n] = 2;
                ++resCount;
            }

        var res = new int[resCount];
        var i = 0;
        var nums = nums2.length > nums1.length ? nums1 : nums2;

        for (var v : nums) {
            if (set[v] == 2) {
                res[i++] = v;
                set[v] = 1;
            }
        }
        return res;
    }
    private static int[] findIntersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num1 : nums1)
            set1.add(num1);

        for (int num2 : nums2)
            if (set1.contains(num2))
                intersection.add(num2);

        return intersection.stream().mapToInt(n -> n).toArray();
    }
}
