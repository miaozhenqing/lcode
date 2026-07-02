package org.example.test;


import org.example.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode[]> subNodeInfo = new ArrayList<>();
        while (head.next != null) {
            //按照长度切分子链表
            ListNode[] listNodes = splitNode(head, k);
            ListNode subNode = listNodes[0];
            head = listNodes[1];
            //对子链表进行反转并保存
            ListNode[] subNodeReversed = reverseList(subNode);
            subNodeInfo.add(subNodeReversed);
        }
        ListNode newHead = subNodeInfo.get(0)[0];
        ListNode lastNode = null;
        //将子链表头尾拼接
        for (int i = 0; i < subNodeInfo.size() - 1; i++) {
            ListNode[] cur = subNodeInfo.get(i);
            ListNode[] next = subNodeInfo.get(i + 1);
            cur[1].next = next[0];
            lastNode = next[1];
        }
        //处理剩余未被切分的链表
        if (lastNode != null) {
            lastNode.next = head;
        }
        return newHead;
    }

    public static ListNode[] splitNode(ListNode head, int k) {
        ListNode subNode = head;
        ListNode pre = null;
        while (head.next != null && k > 0) {
            k--;
            pre = head;
            head = head.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return new ListNode[]{subNode, head};
    }

    public static ListNode[] reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode tail = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return new ListNode[]{pre, tail};
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseKGroup(listNode, 2));//[2,1,4,3,5]

        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseKGroup(listNode2, 3));//[3,2,1,4,5]

    }

}
