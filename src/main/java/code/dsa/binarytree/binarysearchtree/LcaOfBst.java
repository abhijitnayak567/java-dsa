package code.dsa.binarytree.binarysearchtree;

import code.dsa.binarytree.BinaryTreeNode;

/**
 * Problem statement
 * Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.
 *
 * LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants.
 * Example:
 * In this example, the green coloured node is the LCA to A and B.
 * Alt Text
 *
 * Note:
 * It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection from Y, then Y is the lowest common ancestor.
 * Example:
 * Alt Text
 *
 * Note:
 *
 * 1. If out of 2 nodes only one node is present, return that node.
 * 2. If both are not present, return -1.
 * 3. all the node data will be unique.
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints:
 * Time Limit: 1 second
 * Sample Input 1:
 * 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
 * 2 10
 * Sample Output 1:
 * 8
 * Sample Input 2:
 * 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
 * 2 6
 * Sample Output 2:
 * 5
 * Sample Input 3:
 * 8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
 * 12 78
 * Sample Output 3:
 * -1
 */
public class LcaOfBst {
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if(root == null)
            return -1;

        // If a or b is the current node, it's valid LCA (node is descendant of itself)
        if (root.data == a || root.data == b) {
            return root.data;
        }
        // if both values are less than current node, LCA is on left subtree
        if(root.data > a && root.data >b)
            return getLCA(root.left, a, b);

        //if both the values are greater than node, LCA is on right subtree
        else if(root.data < a && root.data < b)
            return getLCA(root.right, a, b);

        // current node is LCA or no LCA
        else if(nodeExists(root.left, a) && nodeExists(root.right, b))
            return root.data;
        else
            return -1;
    }

    private static boolean nodeExists(BinaryTreeNode<Integer> root, int n) {
        if (root == null)
            return false;

        if (root.data == n)
            return true;
        else if (root.data > n)
            return nodeExists(root.left, n);
        else
            return nodeExists(root.right, n);
    }

    public static void main(String[] args) {
        System.out.println(getLCA(BinaryTreeNode.buildTree("8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1"), 2, 10));
        System.out.println(getLCA(BinaryTreeNode.buildTree("8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1"), 2, 6));
        System.out.println(getLCA(BinaryTreeNode.buildTree("8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1"), 12, 78));
    }
}
