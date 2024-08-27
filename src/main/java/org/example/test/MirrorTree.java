package org.example.test;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newLeft = mirrorTree(root.right);
        TreeNode newRight = mirrorTree(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }

    public static void main(String[] args) {
        ////输入：root = [5,7,9,8,3,2,4]
        ////输出：[5,9,7,4,2,3,8]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(8);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);

        TreeNode.printInOrder(new MirrorTree().mirrorTree(root1));
    }
}
