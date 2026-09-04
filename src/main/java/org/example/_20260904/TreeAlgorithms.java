package org.example._20260904;

import org.example.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author mzq
 * @date 2026/9/4 17:44
 */
public class TreeAlgorithms {

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public static void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftTmp = root.left;
        root.left = root.right;
        root.right = leftTmp;
        reverse(root.left);
        reverse(root.right);
    }

    public TreeNode buildTreeFromPreAndIn(int[] preorder, int[] inorder) {
        int parent = preorder[0];


        TreeNode parentNode = new TreeNode(parent);

        parentNode.left = buildTreeFromPreAndIn(preorder, inorder);
        parentNode.right = buildTreeFromPreAndIn(preorder, inorder);
        return parentNode;
    }
}
