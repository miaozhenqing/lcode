package org.example.test;


public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode pre = null;
        ListNode post = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            post = slow.next;
            fast = fast.next;
        }
        pre.next = post;
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(listNode1, 2));//[2]
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(listNode, 2));//[1,2,3,5]

    }

}
