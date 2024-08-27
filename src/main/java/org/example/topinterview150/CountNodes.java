package org.example.topinterview150;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int sum = 1;
        if (root.left != null) {
            sum += countNodes(root.left);
        }
        if (root.right != null) {
            sum += countNodes(root.right);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new CountNodes().countNodes(root));
    }
}
