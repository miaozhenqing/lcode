package org.example.topinterview150;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode doSortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doSortedArrayToBST(nums, start, mid - 1);
        root.right = doSortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new SortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(root);
    }
}
