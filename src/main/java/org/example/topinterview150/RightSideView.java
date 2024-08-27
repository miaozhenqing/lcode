package org.example.topinterview150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> value = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                value.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(value.get(value.size() - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        //输入: [1,2,3,null,5,null,4]
        //输出: [1,3,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new RightSideView().rightSideView(root));

        //输入: [1,null,3]
        //输出: [1,3]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(new RightSideView().rightSideView(root2));

        //输入: []
        //输出: []
        TreeNode root3 = null;
        System.out.println(new RightSideView().rightSideView(root3));
    }
}
