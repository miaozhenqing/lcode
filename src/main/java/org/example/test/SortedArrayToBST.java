package org.example.test;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convertSortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertSortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(num[mid]);
        treeNode.left = convertSortedArrayToBST(num, start, mid - 1);
        treeNode.right = convertSortedArrayToBST(num, mid + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(nums);
        TreeNode.printInOrder(treeNode);
    }

}
