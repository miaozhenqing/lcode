package org.example.topinterview150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValue = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValue.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }

            }
            isLeft = !isLeft;
            result.add(levelValue);
        }
        return result;
    }

    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        //输出：[[3],[20,9],[15,7]]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));

        //root =
        //[1,2,3,4,5]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));

        //[1,2,3,4,null,null,5]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }
}
