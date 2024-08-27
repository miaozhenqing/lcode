package org.example.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(l -> l.val));
        for (ListNode list : lists) {
            ListNode pre;
            while (list != null) {
                pre = list;
                queue.add(pre);
                list = list.next;
                pre.next = null;
            }
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(lists);
        System.out.println(listNode);

        //测试用例:[[-2,-1,-1,-1],[]]
        //	期望结果:[-2,-1,-1,-1]
        ListNode l4 = new ListNode(-2, new ListNode(-1, new ListNode(-1, new ListNode(-1))));
        ListNode[] lists1 = new ListNode[]{l4, null};
        ListNode listNode1 = mergeKLists.mergeKLists(lists1);
        System.out.println(listNode1);
    }
}
