package org.example.test;


public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1, head);
        ListNode curNode = dummyNode;
        while (curNode != null && curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                int value = curNode.next.val;
                while (curNode != null && curNode.val == value) {
                    curNode = curNode.next;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println(deleteDuplicates(listNode));
    }

}
