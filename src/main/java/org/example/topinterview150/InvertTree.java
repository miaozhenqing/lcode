package org.example.topinterview150;


public class InvertTree {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }


    public static void main(String[] args) {
        //生成测试用例root = [2,1,3]
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        System.out.println(new InvertTree().invertTree(root));
        //生成invertTree方法的测试用例:4,2,7,1,3,6,9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(root);
        System.out.println(new InvertTree().invertTree(root));
    }
//
//    public static class TreeNode {
//        public int val;
//        public TreeNode left;
//        public TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            //对TreeNode进行层序遍历，输出结果
//            sb.append("[");
//            Queue<TreeNode> queue = new LinkedList<>();
//
//            queue.add(this);
//            while (!queue.isEmpty()) {
//                TreeNode node = queue.poll();
//                if (node != null) {
//                    sb.append(node.val);
//                    sb.append(",");
//                    queue.add(node.left);
//                    queue.add(node.right);
//                }
//            }
//            sb.append("]");
//            return sb.toString();
//        }
//    }
}
