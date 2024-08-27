package org.example.topinterview150;

public class SumNumbers {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int sum) {
        int a = node.val;
        sum = sum * 10 + a;
        if (node.left == null && node.right == null) {
            res += sum;
            return;
        }
        if (node.left != null) dfs(node.left, sum);
        if (node.right != null) dfs(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new SumNumbers().sumNumbers(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(new SumNumbers().sumNumbers(root2));
    }
}
