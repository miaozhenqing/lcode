package org.example.topinterview150;


public class IsSymmetric {


    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left.val != right.val) {
            return false;
        }
        if ((left.left.val == right.left.val) && (left.right.val == right.right.val)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
    }


}
