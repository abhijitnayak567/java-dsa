package code.dsa.binarytree;
/*
    Problem statement
        You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.
        Print the data of all nodes that have a distance K from the target node. The order in which they would be
        printed will not matter.

    Example:
        For a given input tree(refer to the image below):
        1. Target Node: 5
        2. K = 2
                      3
                    /   \
                   5     1
                  / \   / \
                 6   2 0   8
                /     \
               7       4
        Starting from the target node 5, the nodes at distance K are 7 4 and 1.
      Constraints:
        1 <= N <= 10^5
        Where N is the total number of nodes in the binary tree.
        1 ≤ data of node ≤ 10^9
        1 ≤ target ≤ 10^9
        Time Limit: 1 sec

    Sample Input 1:
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        3 1
    Sample Output 1:
        9
        6
    Sample Input 2:
        1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
        3 3
    Sample Output 2:
        4
        5
    Sample Input 3:
        5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
        6 1
    Sample Output 3:
        2
        3
        5
*/

public class PrintNodesAtDistanceKFromNode {
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        findDistanceAndPrint(root, node, k);
    }

    /**
     * Recursive function to find the target node and print nodes at distance k.
     * Returns the distance of the target node from the current root.
     * Returns -1 if target is not found in the subtree rooted at 'root'.
     */
    private static int findDistanceAndPrint(BinaryTreeNode<Integer> root, int target, int k) {
        if (root == null)
            return -1;

        // Case 1: target node is found
        if (root.data == target) {
            // Print all nodes in the subtree at distance k (downwards)
            printNodesAtDepth(root, k);
            return 0; // Distance from target to itself is 0
        }

        // Case 2: taget node is in left subtree
        int leftDist = findDistanceAndPrint(root.left, target, k);
        if (leftDist != -1) {
            // if current node is at kth distance
            if (leftDist + 1 == k)
                System.out.println(root.data);
                // If current node is closer than k, look for nodes in the right subtree
                // The distance needed in right subtree is: k - (distance to root) - 1 (edge to right child)
            else
                printNodesAtDepth(root.right, k - leftDist - 1 - 1);

            return leftDist + 1;
        }

        // Case 3: target node is in right subtree
        int rightDist = findDistanceAndPrint(root.right, target, k);
        if (rightDist != -1) {
            // if current node is at kth distance
            if (rightDist + 1 == k)
                System.out.println(root.data);
                // If current node is closer than k, look for nodes in the left subtree
                // The distance needed in left subtree is: k - (distance to root) - 1 (edge to left child)
            else
                printNodesAtDepth(root.left, k - rightDist - 1 - 1);

            return rightDist + 1;
        }

        // Target not found in this branch
        return -1;
    }

    private static void printNodesAtDepth(BinaryTreeNode<Integer> root, int depth) {
        if(root == null || depth < 0)
            return;
        if (depth == 0) {
            System.out.println(root.data);
            return;
        }

        printNodesAtDepth(root.left, depth - 1);
        printNodesAtDepth(root.right, depth - 1);
    }

    public static void main(String[] args) {
        nodesAtDistanceK(BinaryTreeNode.buildTree("5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1"), 3, 1);
        System.out.println("-----------------------------");
        nodesAtDistanceK(BinaryTreeNode.buildTree("1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1"), 3, 3);
        System.out.println("-----------------------------");
        nodesAtDistanceK(BinaryTreeNode.buildTree("5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1"), 6, 1);
    }

}
