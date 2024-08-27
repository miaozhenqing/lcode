package org.example.topinterview150;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    Queue<TreeNode> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            queue.add(root);
            inorder(root.right);
        }
    }

    public int next() {
        return hasNext() ? queue.poll().val : 0;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
