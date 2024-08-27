package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list, int k) {
        if (root == null || list.size() >= k) {
            return;
        }
        inorder(root.left, list, k);
        list.add(root.val);
        inorder(root.right, list, k);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new KthSmallest().kthSmallest(root, 1));


        ////输入：root = [5,3,6,2,4,null,null,1], k = 3
        ////输出：3
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);
        System.out.println(new KthSmallest().kthSmallest(root, 3));

    }
}
