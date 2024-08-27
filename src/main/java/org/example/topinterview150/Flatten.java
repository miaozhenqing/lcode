package org.example.topinterview150;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {

            root = root.right;
            flatten(root);
        } else {
            TreeNode tmpRight = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode lastRight = root.right;
            while (lastRight.right != null) {
                lastRight = lastRight.right;
            }
            lastRight.right = tmpRight;
            flatten(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new Flatten().flatten(root);
    }

}
