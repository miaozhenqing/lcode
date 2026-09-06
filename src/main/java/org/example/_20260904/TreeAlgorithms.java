package org.example._20260904;

import org.example.common.TreeNode;

import java.util.*;


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
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndex.put(inorder[i], i);
        }
        return buildTreeFromPreAndIn(preorder, 0, preorder.length - 1
                , inorder, 0, preorder.length - 1, valueIndex);
    }

    public TreeNode buildTreeFromPreAndIn(int[] preorder, int preStart, int preEnd
            , int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueIndex) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int root = preorder[preStart];
        int rootIndex = valueIndex.get(root);


        TreeNode rootNode = new TreeNode(root);
        //1 234 567
        //123 4 567
        int leftSize = rootIndex - inStart;
        rootNode.left = buildTreeFromPreAndIn(preorder, preStart + 1, preStart + leftSize
                , inorder, inStart, rootIndex - 1, valueIndex);
        rootNode.right = buildTreeFromPreAndIn(preorder, preStart + leftSize + 1, preEnd
                , inorder, rootIndex + 1, inEnd, valueIndex);
        return rootNode;
    }

    //123 567 4
    //123 4 567
    public TreeNode buildTreeFromPostAndIn(int[] postorder, int postStart, int postEnd
            , int[] inorder, int inStart, int inEnd
            , Map<Integer, Integer> valueIndex
    ) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int root = postorder[postEnd];
        TreeNode rootNode = new TreeNode(root);
        int rootIndex = valueIndex.get(root);

        int leftSize = rootIndex - inStart;
        rootNode.left = buildTreeFromPostAndIn(postorder, postStart, postStart + leftSize
                , inorder, inStart, rootIndex - 1, valueIndex);
        rootNode.right = buildTreeFromPostAndIn(postorder, postStart + leftSize, postEnd - 1
                , inorder, rootIndex + 1, inEnd, valueIndex);
        return rootNode;
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                last = poll;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(last.val);
        }
        return res;
    }

    /**
     * 1
     * 2  3
     * 4 5
     */
    private void rightSideView_dfs(TreeNode node, List<Integer> res, int depth) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            //该层第一次访问
            res.add(node.val);
        }
        rightSideView_dfs(node.right, res, depth + 1);
        rightSideView_dfs(node.left, res, depth + 1);
    }

    /**
     * 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;  // p 和 q 都在右子树
        }
        if (right == null) {
            return left;   // p 和 q 都在左子树
        }
        return root;       // p 和 q 分别在左右子树，当前节点就是 LCA

    }

    private int maxPathSum = -Integer.MAX_VALUE;

    /**
     * 最大路径和
     *
     * @param root
     * @return
     */
    public int maxPathSum_dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxPathSum_dfs(root.left), 0);
        int rightGain = Math.max(maxPathSum_dfs(root.right), 0);
        maxPathSum = Math.max(maxPathSum, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }

    private int pathSumRes = 0;

    public void pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        pathSum_dfs(root, 0, targetSum, sumToCount);
    }

    public void pathSum_dfs(TreeNode root, int currentSum, int targetSum, Map<Integer, Integer> sumToCount) {
        if (root == null) {
            return;
        }
        //更新当前前缀和
        currentSum += root.val;
        //是否存在
        Integer count = sumToCount.getOrDefault(currentSum - targetSum, 0);
        pathSumRes += count;
        sumToCount.put(currentSum, sumToCount.getOrDefault(currentSum, 0) + 1);
        pathSum_dfs(root.left, currentSum, targetSum, sumToCount);
        pathSum_dfs(root.right, currentSum, targetSum, sumToCount);
        sumToCount.put(currentSum, sumToCount.get(currentSum) - 1);
    }

    //=============树的序列化和反序列化
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize_pre(root, str);
        return str.toString();
    }

    public void serialize_pre(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null").append(",");
            return;
        }
        str.append(root.val).append(",");
        serialize_pre(root.left, str);
        serialize_pre(root.right, str);
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return deserialize_create(new LinkedList<>(Arrays.asList(split)));
    }

    public TreeNode deserialize_create(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize_create(queue);
        root.right = deserialize_create(queue);
        return root;
    }

    //==========是否二叉搜索树
    public boolean isValidBST(TreeNode root) {
        // 从根节点开始，范围是 (-∞, +∞)
        return isValidBST_dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST_dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        boolean leftValid = isValidBST_dfs(root.left, min, root.val);
        boolean rightValid = isValidBST_dfs(root.right, root.val, max);
        return leftValid && rightValid;
    }


}
