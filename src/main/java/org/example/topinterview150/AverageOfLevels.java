package org.example.topinterview150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }


    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new AverageOfLevels().averageOfLevels(root));

        //输入：root = [3,9,20,15,7]
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(new AverageOfLevels().averageOfLevels(root2));

        //root =
        //[1,1]
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        System.out.println(new AverageOfLevels().averageOfLevels(root3));

        //root =
        //[3,1,5,0,2,4,6]
        TreeNode root4 = new TreeNode(3);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(5);
        root4.left.left = new TreeNode(0);
        root4.left.right = new TreeNode(2);
        root4.right.left = new TreeNode(4);
        root4.right.right = new TreeNode(6);
        System.out.println(new AverageOfLevels().averageOfLevels(root4));
    }
}
