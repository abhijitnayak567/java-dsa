package code.dsa.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/

 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.

 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9

 * Example 3:
 * Input: nums = [1,0,1,2]
 * Output: 3

 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLen = 0;
        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int nextNum = num + 1;
                int curLen = 1;
                while (numsSet.contains(nextNum)) {
                    curLen++;
                    nextNum++;
                }
                if (curLen > maxLen)
                    maxLen = curLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        System.out.println(sequence.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(sequence.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(sequence.longestConsecutive(new int[]{1,0,1,2}));
    }
}
