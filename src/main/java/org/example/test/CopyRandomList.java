package org.example.test;


import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    static Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node newNode = new Node(head.val);
            cachedNode.put(head, newNode);
            newNode.next = copyRandomList2(head.next);
            newNode.random = copyRandomList2(head.random);
        }
        return cachedNode.get(head);
    }

    public static void main(String[] args) {
        // 创建测试用例
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        // 设置节点的next指针
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 设置节点的random指针
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node copyHead = copyRandomList2(node1);

        // 验证结果
        while (copyHead != null) {
            System.out.println("val: " + copyHead.val);
            if (copyHead.random != null) {
                System.out.println("random: " + copyHead.random.val);
            } else {
                System.out.println("random: null");
            }
            copyHead = copyHead.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
