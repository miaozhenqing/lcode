package org.example.topinterview150;


public class MaxDepth {
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = 0;
        if (node.left != null) {
            maxLeft += maxDepth(node.left);
        }
        int maxRight = 0;
        if (node.right != null) {
            maxRight += maxDepth(node.right);
        }
        return Math.max(maxLeft, maxRight) + 1;
    }

    public static void main(String[] args) {
        //针对maxDepth 生成测试用例
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaxDepth().maxDepth(root));

    }

}
