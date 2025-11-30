package code.dsa.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //method to build tree from level order input
    public static BinaryTreeNode<Integer> buildTree(int[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(nodes[0]);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            BinaryTreeNode<Integer> current = queue.poll();

            if (i < nodes.length && nodes[i] != -1) {
                current.left = new BinaryTreeNode<>(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != -1) {
                current.right = new BinaryTreeNode<>(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(String nodesInput) {
        int[] nodes =Arrays.stream(nodesInput.split(" ")).mapToInt(Integer::valueOf).toArray();
        return buildTree(nodes);
    }

}
