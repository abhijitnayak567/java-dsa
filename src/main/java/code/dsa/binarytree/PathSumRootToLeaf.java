package code.dsa.binarytree;

import java.util.ArrayList;

/*
Problem statement
For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node
data along the path is equal to K.

if there are a total of two paths, starting from the root and ending at the leaves which sum up to a value of K = 13.
The paths are:
a. 2 3 4 4
b. 2 3 8

One thing to note here is, there is another path in the right sub-tree in reference to the root, which sums up to 13 but
since it doesn't end at the leaf, we discard it.
The path is: 2 9 2(not a leaf)
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
13
 Sample Output 1:
2 3 4 4
2 3 8
Sample Input 2:
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13
 Sample Output 2:
5 6 2
5 7 1
 */
public class PathSumRootToLeaf {
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        findPath(root, k, 0, new ArrayList<>());
    }

    private static void findPath(BinaryTreeNode<Integer> root, int target, int currentSum,
                                               ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.data);
        currentSum += root.data;

        //check if leaf node
        if (root.left == null && root.right == null) {
            // check if target achieved
            if (currentSum == target)
                printPath(path);
        } else if (currentSum < target) {
            // recursively find next path if current sum is less than taget sum
            findPath(root.left, target, currentSum, path);
            findPath(root.right, target, currentSum, path);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    private static void printPath(ArrayList<Integer> path) {
        path.forEach(node -> System.out.print(node + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        rootToLeafPathsSumToK(BinaryTreeNode.buildTree("2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1"), 13);
        System.out.println("---------------------------------");
        rootToLeafPathsSumToK(BinaryTreeNode.buildTree("5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1"), 13);
    }
}
