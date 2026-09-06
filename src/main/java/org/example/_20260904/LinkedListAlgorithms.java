package org.example._20260904;

import org.example.common.ListNode;

public class LinkedListAlgorithms {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        //1--2--3--4
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //fast走2步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //fast走2步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if (nodeA == null) {
                nodeA = headB;
            }
            if (nodeB == null) {
                nodeB = headA;
            }
        }
        return nodeA;
    }

    //删除倒数第N个阶段
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        n++;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    //反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode d = new ListNode();
        d.next = head;
        //1,2,3,4,5
        ListNode pre = d;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode subTail = pre;
        for (int i = 0; i < right - left + 1; i++) {
            subTail = subTail.next;
        }
        //子链表头
        ListNode subHead = pre.next;
        //剩余列表头
        ListNode next = subTail.next;
        subTail.next = null;

        ListNode newHead = reverseList(subHead);

        pre.next = newHead;
        subHead.next = next;
        return d.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail=head;
        for (int i = 0; i < k; i++) {
            if (tail==null){
                return head;
            }
            tail=tail.next;
        }
        //1->2->3->4->5
        //3<-2<-1 4->5
        ListNode newHead = reverse(head, tail);

        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


}
