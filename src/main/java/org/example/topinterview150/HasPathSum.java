package org.example.topinterview150;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        int leftValue = targetSum - root.val;
        return hasPathSum(root.left, leftValue) || hasPathSum(root.right, leftValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new HasPathSum().hasPathSum(root, 22));

        //root = [1,2,3], targetSum = 5
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new HasPathSum().hasPathSum(root, 5));

        //root = [1,2], targetSum = 1

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new HasPathSum().hasPathSum(root, 1));
    }
}
