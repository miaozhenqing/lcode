package org.example.test;

public class IsValidBST {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);

    }

    public static void main(String[] args) {

        //输入：root = [2,1,3]
        //输出：true
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(new IsValidBST().isValidBST(root2));

        //输入：root = [5,1,4,null,null,3,6]
        //输出：false
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(new IsValidBST().isValidBST(root));

        //输入：root = [1,null,1]
        //输出：false
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(1);
        System.out.println(new IsValidBST().isValidBST(root1));

        //输入：root = [5,4,6,null,null,3,7]
        //输出：false
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(6);
        root3.right.left = new TreeNode(3);
        root3.right.right = new TreeNode(7);
        System.out.println(new IsValidBST().isValidBST(root3));

        //输入：[-2147483648]
        //输出：true
        TreeNode root4 = new TreeNode(-2147483648);
        System.out.println(new IsValidBST().isValidBST(root4));


    }
}
