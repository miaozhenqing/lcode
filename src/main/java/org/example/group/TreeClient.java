package org.example.group;

import org.example.common.TreeNode;

import java.util.*;
/**
 *
 * 二叉树相关算法
 *
 *
 * 1
 * /  \
 * 2    3
 * / \   /  \
 * 4  5  6   7
 * /\
 * 8  9
 * 前序遍历: 1 2 4 5 8 9 3 6 7
 * 中序遍历: 4 2 8 5 9 1 6 3 7
 * 后序遍历: 4 8 9 5 2 6 7 3 1
 */
public class TreeClient {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(8),
                                new TreeNode(9)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );
        TreeNode node2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(8),
                                new TreeNode(9)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );

        TreeNode symmetricNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );
        //根据前序、中序还原二叉树
//        int[] preorder = new int[]{1, 2, 4, 5, 8, 9, 3, 6, 7};
//        int[] inorder = new int[]{4, 2, 8, 5, 9, 1, 6, 3, 7};
//        TreeNode treeNode = buildTree(preorder, inorder);
//        TreeNode.printInOrder(treeNode);
        //二叉树展开为列表
//        flatten(symmetricNode);
//        TreeNode.printInOrder(symmetricNode);
        //路径总和
        //输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        //输出：true
//        TreeNode node1 = new TreeNode(5,
//                new TreeNode(4,
//                        new TreeNode(11,
//                                new TreeNode(7),
//                                new TreeNode(2)
//                        ),
//                        null
//                ),
//                new TreeNode(8,
//                        new TreeNode(13),
//                        new TreeNode(4,
//                                new TreeNode(5),
//                                new TreeNode(1)
//                        )
//                )
//        );
//        System.out.println(hasPathSum(node1, 22));
        //路径总和II
        //输入：root = [1,2,3]
        //输出：25
//        TreeNode node3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        System.out.println(sumNumbers(node3));
        //完全二叉树的节点个数
//        System.out.println(countNodes(symmetricNode));
        //二叉树的右视图
        //输入：root = [1,2,3,null,5,null,4]
        //输出：[1,3,4]
//        TreeNode node4 = new TreeNode(1,
//                new TreeNode(2,
//                        new TreeNode(5),
//                        null
//                ),
//                new TreeNode(3,
//                        new TreeNode(4),
//                        new TreeNode(6)
//                )
//        );
//        System.out.println(rightSideView(node4));
        //二叉树的右视图
        //输入：root = [1,2,3,null,5,null,4]
        //输出：[1,3,4]
//        TreeNode node4 = new TreeNode(1,
//                new TreeNode(2,
//                        new TreeNode(5),
//                        null
//                ),
//                new TreeNode(3,
//                        new TreeNode(4),
//                        new TreeNode(6)
//                )
//        );
//        System.out.println(rightSideView(node4));
        //二叉搜索树的最小绝对差
        //输入：root = [4,2,6,1,3]
        //输出：1
//        TreeNode node4 = new TreeNode(4,
//                new TreeNode(2,
//                        new TreeNode(1),
//                        new TreeNode(3)
//                ),
//                new TreeNode(6)
//        );
//        System.out.println(getMinimumDifference(node4));
        //输入：root = [1,0,48,null,null,12,49]
        //输出：1
//        TreeNode node5 = new TreeNode(1,
//                null,
//                new TreeNode(48,
//                        new TreeNode(12),
//                        new TreeNode(49)
//                )
//        );
//        System.out.println(getMinimumDifference(node5));
        //二叉搜索树中第K小的元素
//        TreeNode node6 = new TreeNode(5,
//                new TreeNode(3,
//                        new TreeNode(2,
//                                new TreeNode(1),
//                                null
//                        ),
//                        new TreeNode(4)
//                ),
//                new TreeNode(6)
//        );
//        System.out.println(kthSmallest(node6, 3));//3
        //二叉树的最近公共祖先
//        TreeNode node7 = new TreeNode(3,
//                new TreeNode(5,
//                        new TreeNode(6),
//                        new TreeNode(2,
//                                new TreeNode(7),
//                                new TreeNode(4)
//                        )
//                ),
//                new TreeNode(1,
//                        new TreeNode(0),
//                        new TreeNode(8)
//                )
//        );
//        System.out.println(lowestCommonAncestor(node7, node7.left, node7.right).val);//3
        //二叉树的锯齿形层序遍历
        TreeNode node8 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        System.out.println(zigzagLevelOrder(node8));//[[3],[20,9],[15,7]]
    }

    //二叉树的锯齿形层序遍历
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size1 = deque.size();
            for (int i = 0; i < size1; i++) {
                TreeNode n = deque.removeFirst();
                tmp.add(n.val);
                if (n.left != null) {
                    deque.addLast(n.left);
                }
                if (n.right != null) {
                    deque.addLast(n.right);
                }
            }
            res.add(tmp);
            if (deque.isEmpty()) {
                break;
            }

            int size2 = deque.size();
            tmp = new ArrayList<>();
            for (int i = 0; i < size2; i++) {
                TreeNode n = deque.removeLast();
                tmp.add(n.val);
                if (n.right != null) {
                    deque.addFirst(n.right);
                }
                if (n.left != null) {
                    deque.addFirst(n.left);
                }
            }
            res.add(tmp);
        }
        return res;
    }


    //二叉树的最近公共祖先
    private static Map<TreeNode, TreeNode> nodeParent = new HashMap<>();
    private static Set<TreeNode> visitedSet = new HashSet<>();

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor_dfs(root);
        while (p != null) {
            visitedSet.add(p);
            p = nodeParent.get(p);
        }
        while (q != null) {
            if (visitedSet.contains(q)) {
                return q;
            }
            q = nodeParent.get(q);
        }
        return null;
    }

    private static void lowestCommonAncestor_dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            nodeParent.put(root.left, root);
            lowestCommonAncestor_dfs(root.left);
        }
        if (root.right != null) {
            nodeParent.put(root.right, root);
            lowestCommonAncestor_dfs(root.right);
        }
    }

    /**
     * 二叉搜索树中第K小的元素
     */
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest_byInOrder(root, list, k);
        return list.get(k - 1);
    }

    public static void kthSmallest_byInOrder(TreeNode node, List<Integer> list, int k) {
        if (node == null || list.size() >= k) {
            return;
        }
        kthSmallest_byInOrder(node.left, list, k);
        list.add(node.val);
        kthSmallest_byInOrder(node.right, list, k);
    }

    /**
     * 二叉搜索树的最小绝对差
     */
    public static int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, Math.abs(root.val - root.left.val));
            int leftMin = getMinimumDifference(root.left);
            min = Math.min(min, leftMin);
        }
        if (root.right != null) {
            min = Math.min(min, Math.abs(root.val - root.right.val));
            int rightMin = getMinimumDifference(root.right);
            min = Math.min(min, rightMin);
        }
        return min;
    }

    /**
     * 二叉树的右视图
     */
    public static List<Integer> rightSideView(TreeNode root) {
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

    /**
     * 完全二叉树的节点个数
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * 路径总和 II
     */
    public static int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        sumNumbers_backtrack(root, res, path);
        return res.stream().mapToInt(Integer::intValue).sum();
    }

    private static void sumNumbers_backtrack(TreeNode node, List<Integer> res, List<Integer> path) {
        if (node.left == null && node.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : path) {
                stringBuilder.append(integer);
            }
            res.add(Integer.parseInt(stringBuilder.toString()));
            return;
        }
        if (node.left != null) {
            path.add(node.left.val);
            sumNumbers_backtrack(node.left, res, path);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.right.val);
            sumNumbers_backtrack(node.right, res, path);
            path.remove(path.size() - 1);
        }
    }

    /*
    路径总和
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        int leftValue = targetSum - root.val;
        return hasPathSum(root.left, leftValue) || hasPathSum(root.right, leftValue);
    }


    /**
     * 中序遍历
     */
    public static void printIn(TreeNode node) {
        if (node == null) {
            return;
        }
        printIn(node.left);
        System.out.print(node.val + " - ");
        printIn(node.right);
    }

    /**
     * 前序遍历
     */
    public static void printPre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " - ");
        printPre(node.left);
        printPre(node.right);
    }

    /**
     * 后续遍历
     */
    public static void printPost(TreeNode node) {
        if (node == null) {
            return;
        }
        printPost(node.left);
        printPost(node.right);
        System.out.print(node.val + " - ");
    }

    /**
     * 层次遍历
     */
    public static void printByLevel(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " - ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    /**
     * 最大深度
     */
    public static int maxLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = 1;
        if (node.left != null) {
            maxLeft += maxLevel(node.left);
        }
        int maxRight = 1;
        if (node.right != null) {
            maxRight += maxLevel(node.right);
        }
        return Math.max(maxLeft, maxRight);
    }

    /**
     * 相同二叉树
     */
    public static boolean sameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            boolean sameLeft = sameTree(node1.left, node2.left);
            boolean sameRight = sameTree(node1.right, node2.right);
            if (sameLeft && sameRight) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对称二叉树
     */
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.right);
        }
        return false;
    }

    /**
     * 从前序、中序结果构造二叉树
     * [3,9,20,15,7]
     * [9,3,15,20,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int headValue = preorder[0];
        int middleIndex_leftPreorderNum = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (headValue == inorder[i]) {
                middleIndex_leftPreorderNum = i;
                break;
            }
        }
        TreeNode head = new TreeNode(headValue);
        //左子树的前序遍历
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, middleIndex_leftPreorderNum + 1);
        //右子树的前序遍历
        int[] rightPreorder = Arrays.copyOfRange(preorder, middleIndex_leftPreorderNum + 1, preorder.length);
        //左子树的中序遍历
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, middleIndex_leftPreorderNum);
        //右子树的中序遍历
        int[] rightInorder = Arrays.copyOfRange(inorder, middleIndex_leftPreorderNum + 1, inorder.length);
        head.left = buildTree(leftPreorder, leftInorder);
        head.right = buildTree(rightPreorder, rightInorder);
        return head;
    }

    /**
     * 二叉树展开为列表
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        flattenByPreOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }

    private static void flattenByPreOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        flattenByPreOrder(node.left, list);
        flattenByPreOrder(node.right, list);
    }
}
