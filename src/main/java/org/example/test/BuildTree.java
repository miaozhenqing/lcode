package org.example.test;

import java.util.Arrays;

public class BuildTree {

    public TreeNode buildTree111(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        int middleIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == head.val) {
                middleIndex = i;
                break;
            }
        }
        int end = 0;
        //找到左子树和右子树的前序遍历数组
        for (int i = 1; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                end = i;
                break;
            }
        }
        //左子树的前序遍历
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, end + 1);
        //右子树的前序遍历
        int[] rightPreorder = Arrays.copyOfRange(preorder, end + 1, preorder.length);
        //左子树的中序遍历
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, middleIndex);
        //右子树的中序遍历
        int[] rightInorder = Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length);
        TreeNode left = buildTree111(leftPreorder, leftInorder);
        TreeNode right = buildTree111(rightPreorder, rightInorder);
        head.left = left;
        head.right = right;
        return head;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //生成测试用例：输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //输出: [3,9,20,null,null,15,7]
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
//        BuildTree buildTree = new BuildTree();
//        TreeNode treeNode = buildTree.buildTree111(preorder, inorder);
//        System.out.println(treeNode);
        //生成测试用例：输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//        输出：[3,9,20,null,null,15,7]
//        int[] inorder = {9, 3, 15, 20, 7};
//        int[] postorder = {9, 15, 7, 20, 3};
//        BuildTree buildTree = new BuildTree();
//        TreeNode treeNode = buildTree.buildTree2(inorder, postorder);
//        System.out.println(treeNode);
        //生成测试用例：输入：inorder = [4, 2, 5, 1, 6, 3, 7], postorder = [4, 5, 2, 6, 7, 3, 1]

        int[] inorder1 = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder1 = {4, 5, 2, 6, 7, 3, 1};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode1 = buildTree.buildTree2(inorder1, postorder1);
        System.out.println(treeNode1);
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postorder.length - 1]);
        if (inorder.length == 1 && postorder.length == 1) {
            return head;
        }

        int middleIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == head.val) {
                middleIndex = i;
                break;
            }
        }
        //左子树的中序遍历
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, middleIndex);
        //右子树的中序遍历
        int[] rightInorder = Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length);


        int end = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == rightInorder[0]) {//左子树后序遍历的最后一个值，链接着右子树中序遍历第 一个值
                end = i;
                break;
            }
        }
        //左子树的后序遍历
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, end);
        //右子树的后序遍历
        int[] rightPostorder = Arrays.copyOfRange(postorder, end, postorder.length - 1);

        TreeNode left = buildTree2(leftInorder, leftPostorder);
        TreeNode right = buildTree2(rightInorder, rightPostorder);
        head.left = left;
        head.right = right;
        return head;
    }
}
