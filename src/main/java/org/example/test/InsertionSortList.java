package org.example.test;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = null;
            addToOrder(dummyHead, current);
        }
        return dummyHead.next;
    }

    private void addToOrder(ListNode dummyHead, ListNode node) {
        ListNode pre = dummyHead;
        ListNode current = dummyHead.next;
        while (current != null) {
            if (current.val < node.val) {
                pre = current;
                current = current.next;
            } else {
                pre.next = node;
                node.next = current;
                break;
            }
        }
        if (current == null) {
            pre.next = node;
        }
    }

    public static void main(String[] args) {
        //输入: head = [4,2,1,3]
        //输出: [1,2,3,4]
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        System.out.println(new InsertionSortList().insertionSortList(node));
        //输入: head = [-1,5,3,4,0]
        //输出: [-1,0,3,4,5] 
        node = new ListNode(-1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(0);
        System.out.println(new InsertionSortList().insertionSortList(node));
    }
}
