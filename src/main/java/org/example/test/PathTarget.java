package org.example.test;

import java.util.ArrayList;
import java.util.List;

public class PathTarget {
    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();

        path.add(root.val);
        backtrace(res, path, root, target);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> path, TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
        }
        if (root.left != null) {
            path.add(root.left.val);
            backtrace(res, path, root.left, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            backtrace(res, path, root.right, target);
            path.remove(path.size() - 1);
        }
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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new PathTarget().pathTarget(root, 22));
        //root = [1,2,3], targetSum = 5
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new PathTarget().pathTarget(root, 5));
        //输入：root = [1,2], targetSum = 0
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new PathTarget().pathTarget(root, 0));
    }
}
