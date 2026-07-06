package org.example._20260630;

import org.example.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeAlgorithms {


    //======================preorder

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static void levelorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
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

    public int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    //==============锯齿形遍历==偶数层翻转一下
    // 直接输出的锯齿形遍历（翻转方式）
    public static void sawtoothOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            // 收集当前层所有节点值
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // 按正常顺序加入子节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 处理输出方向
            if (!isLeftToRight) {
                Collections.reverse(currentLevel);
            }

            // 直接输出当前层结果
            System.out.println(currentLevel);
            isLeftToRight = !isLeftToRight;
        }
    }

    // 方法三：双端队列实现锯齿形遍历（最优解）
    public static void sawtoothOrderV2(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        boolean isLeftToRight = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            // 根据方向选择不同的遍历方式
            for (int i = 0; i < levelSize; i++) {
                if (isLeftToRight) {
                    // 从左到右：从队头取出节点，子节点从队尾加入（先左后右）
                    TreeNode node = deque.pollFirst();
                    currentLevel.add(node.val);

                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    // 从右到左：从队尾取出节点，子节点从队头加入（先右后左）
                    TreeNode node = deque.pollLast();
                    currentLevel.add(node.val);

                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
            }

            // 直接输出当前层结果（无需反转）
            System.out.println(currentLevel);
            isLeftToRight = !isLeftToRight;
        }
    }


    public static void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        reverse(root.left);
        reverse(root.right);
    }

    public TreeNode buildTreeFromPreAndIn(int[] preorder, int[] inorder, Map<Integer, Integer> valueIndex) {
        if (preorder == null || inorder == null) {
            return null;
        }
        //父节点
        int rootValue = preorder[0];
        int rootIndex = valueIndex.get(rootValue);

        TreeNode treeNode = new TreeNode(rootValue);

        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + inorderLeft.length, preorder.length);

        treeNode.left = buildTreeFromPreAndIn(preorderLeft, inorderLeft, valueIndex);
        treeNode.right = buildTreeFromPreAndIn(preorderRight, inorderRight, valueIndex);
        return treeNode;
    }

    public TreeNode buildTreeFromPreAndInV2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueIndex) {
        if (preorder == null || inorder == null || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //父节点
        int rootValue = preorder[preStart];
        int rootIndex = valueIndex.get(rootValue);
        TreeNode treeNode = new TreeNode(rootValue);


        //1,234,567
        //123,4,567
        int leftSize = rootIndex - inStart;
        treeNode.left = buildTreeFromPreAndInV2(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1, valueIndex);
        treeNode.right = buildTreeFromPreAndInV2(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd, valueIndex);
        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        reverse(root);

        System.out.println(root);
    }

}
