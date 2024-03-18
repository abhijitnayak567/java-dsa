package code.dsa;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumLL {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int[] arr) {
            ListNode list = null;
            ListNode head = null;
            for (int i : arr)
                if (null == head) {
                    list = new ListNode(i);
                    head = list;
                } else {
                    list.next = new ListNode(i);
                    list = list.next;
                }
            this.val = head.val;
            this.next = head.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(val).append(", ");
            ListNode node = this;
            while (node.next != null) {
                node = node.next;
                sb.append(node.val).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, -3, 3, 1});
        System.out.println(head + " -> " + removeZeroSumSubLists(head));
        head = new ListNode(new int[]{1, 2, 3, -3, 4});
        System.out.println(head + " -> " + removeZeroSumSubLists(head));
        head = new ListNode(new int[]{1, 2, 3, -3, -2});
        System.out.println(head + " -> " + removeZeroSumSubLists(head));
        head = new ListNode(new int[]{5, -3, -4, 1, 6, -2, -5});
        System.out.println(head + " -> " + removeZeroSumSubLists(head));
    }

    /*
     * Intuition:
     *  The intuition behind this approach is to use the concept of prefix sum combined with a hash map. A prefix sum
     *  here represents the cumulative sum of the nodes from the start up to the current node. By storing these prefix
     *  sums and their corresponding nodes in a hash map, we can easily identify parts of the list that sum up to
     *  zero. When we encounter a prefix sum that we've seen before, it indicates that the sum of the nodes between
     *  the previous occurrence and the current node is zero, and those nodes can be removed.
     *
     * Approach:
     *  Initialize a dummy head node (result) to simplify edge cases, such as when the starting elements of the list sum
     *  to zero.
     *
     *  Traverse the linked list, calculating the cumulative or prefix sum of node values as you go.
     *
     *  Use a hash map to keep track of the first occurrence of each prefix sum and the corresponding node.
     *  If a prefix sum is encountered that already exists in the map, it indicates the sublist from the next of the
     *  stored node up to the current node sums to zero. Remove this sublist by linking the stored node's next
     *  pointer to the current node's next.
     *  After adjusting pointers, continue traversing the list from the next node.
     *
     * Complexity:
     *  Time complexity: O(n)O(n) - The entire list is traversed only once.
     *  Space complexity: O(n)O(n) - In the worst case, the hash map could store an entry for each node if no
     *  zero-sum sublists are found or if they are found at the end.
     */
    public static ListNode removeZeroSumSubLists(ListNode head) {
        // Dummy head to handle edge case when nodes at the beginning sum to zero
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Prefix sum initialization
        int prefixSum = 0;

        // Map to store the first occurrence of a prefix sum and its corresponding node
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();

        // Iterate over the list
        for (ListNode current = dummy; current != null; current = current.next) {
            prefixSum += current.val;
            // If this prefix sum has been seen before, it means the sublist sums to zero
            if (prefixSumToNode.containsKey(prefixSum)) {
                // Retrieve the node where this prefix sum was first seen
                ListNode prev = prefixSumToNode.get(prefixSum);
                ListNode toRemove = prev.next;
                int p = prefixSum + (toRemove != null ? toRemove.val : 0);

                // Remove nodes between 'prev' and 'current' from the map
                while (p != prefixSum) {
                    prefixSumToNode.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }

                // Connect the previous node with current's next, effectively removing the zero-sum sublist
                prev.next = current.next;
            } else {
                // If this is a new prefix sum, just add it to the map
                prefixSumToNode.put(prefixSum, current);
            }
        }
        // Return the modified list, without the dummy head
        return dummy.next;
    }
}
