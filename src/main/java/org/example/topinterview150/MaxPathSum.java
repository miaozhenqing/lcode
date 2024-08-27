package org.example.topinterview150;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        doMaxPathSum(root);
        return max;
    }
    public int doMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(doMaxPathSum(root.left), 0);
        int maxRight = Math.max(doMaxPathSum(root.right), 0);
        max = Math.max(root.val + maxRight + maxLeft, max);
        return root.val + Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new MaxPathSum().maxPathSum(root));

        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(new MaxPathSum().maxPathSum(root2));

        TreeNode root3 = new TreeNode(0);
        System.out.println(new MaxPathSum().maxPathSum(root3));
    }
}
