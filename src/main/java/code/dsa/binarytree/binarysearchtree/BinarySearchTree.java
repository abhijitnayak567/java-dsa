package code.dsa.binarytree.binarysearchtree;

import code.dsa.binarytree.BinaryTreeNode;

/**
 *
 * read about AVL Trees and Red Black trees
 */
public class BinarySearchTree<T extends Number & Comparable<T>> {
    public BinaryTreeNode<T> root;
    public int size;

    public boolean isPresent(T x) {
        return isPresent(root, x);
    }

    private static <T extends Number & Comparable<T>> boolean isPresent(BinaryTreeNode<T> node, T x) {
        if (node == null)
            return false;
        if (node.data == x)
            return true;
        else if (x.compareTo(node.data) < 0)
            return isPresent(node.left, x);
        else
            return isPresent(node.right, x);
    }

    public void insert(T x) {
        root = insert(root, x);
        size++;
    }

    private static <T extends Number & Comparable<T>> BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T x) {
        if (node == null)
            node = new BinaryTreeNode<>(x);
        else if (x.compareTo(node.data) <= 0)
            node.left = insert(node.left, x);
        else
            node.right = insert(node.right, x);
        return node;
    }

    public void printTree() {
        printTree(root);
    }

    private static <T extends Number & Comparable<T>> void printTree(BinaryTreeNode<T> node) {
        if (node == null)
            return;
        System.out.print(node.data + ": ");
        if (node.left != null)
            System.out.print("L: " + node.left.data);
        if (node.right != null)
            System.out.print(", R: " + node.right.data);
        System.out.println();
        printTree(node.left);
        printTree(node.right);
    }

    public void remove(T x) {
        if (isPresent(x)) {
            root = remove(root, x);
            size--;
        }
    }

    private static <T extends Number & Comparable<T>> BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T x) {
        if (node == null)
            return null;

        if (node.data.compareTo(x) < 0)
            node.right = remove(node.right, x);
        else if (node.data.compareTo(x) > 0)
            node.left = remove(node.left, x);
        else {
            // Node to delete found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Node has both children - get inorder successor
            node.data = min(node.right);
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    private static <T extends Number & Comparable<T>> T min(BinaryTreeNode<T> node) {
        if (node == null)
            return null;
        T minVal = node.data;
        while(node.left!=null) {
            minVal = node.data;
            node = node.left;
        }
        return minVal;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(9);
        tree.insert(12);
        tree.insert(7);
        tree.insert(5);
        System.out.println("Size - " + tree.size);
        tree.printTree();
        System.out.println("isPresent(32) = " + tree.isPresent(32));
        System.out.println("isPresent(7) = " + tree.isPresent(7));
        tree.remove(12);
        System.out.println("Size - " + tree.size);
        tree.printTree();
        tree.remove(9);
        System.out.println("Size - " + tree.size);
        tree.printTree();
        tree.remove(5);
        System.out.println("Size - " + tree.size);
        tree.printTree();

    }
}

