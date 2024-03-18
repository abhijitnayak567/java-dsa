package code.dsa;


// https://leetcode.com/problems/minimum-common-value/description/?envType=daily-question&envId=2024-03-09
public class MinimumCommonValue {

    public static void main(String[] args) {
        System.out.println(getCommon(new int[] {1,2,3}, new int[] {2,4}));
        System.out.println(getCommon(new int[] {1,2,3,6}, new int[] {2,3,4,5}));
    }

    private static int getCommon(int[] nums1, int[] nums2) {
        if (nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0])
            return -1;

        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }

        return -1;
    }
}
