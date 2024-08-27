package org.example.test;

public class GetMinimumDifference {
    private TreeNode prevNode = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        // 中序遍历BST
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (prevNode != null) {
            minDiff = Math.min(minDiff, node.val - prevNode.val);
        }
        prevNode = node;
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new GetMinimumDifference().getMinimumDifference(root));

    }

}
