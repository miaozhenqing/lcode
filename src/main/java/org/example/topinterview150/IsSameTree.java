package org.example.topinterview150;


public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val == q.val) {
            boolean sameLeft = isSameTree(p.left, q.left);
            boolean sameRight = isSameTree(p.right, q.right);
            if (sameLeft && sameRight) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //为IsSameTree方法生成测试数据
        //p =
        //[1,2]
        //q =
        //[1,null,2]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.left = null;
        q.right = new TreeNode(2);
        System.out.println(new IsSameTree().isSameTree(p, q));
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
