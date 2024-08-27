package org.example.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoLists {

    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        ListNode list1Temp = list1;
        ListNode list2Temp = list2;
        while (list1Temp != null || list2Temp != null) {
            if (list1Temp == null) {
                current.next = new ListNode(list2Temp.val);
                list2Temp = list2Temp.next;
                current = current.next;
                continue;
            }
            if (list2Temp == null) {
                current.next = new ListNode(list1Temp.val);
                list1Temp = list1Temp.next;
                current = current.next;
                continue;
            }
            if (list1Temp.val <= list2Temp.val) {
                current.next = new ListNode(list1Temp.val);
                list1Temp = list1Temp.next;
                current = current.next;
            } else {
                current.next = new ListNode(list2Temp.val);
                list2Temp = list2Temp.next;
                current = current.next;
            }
        }
        return head.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode listNode111 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode222 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists3(listNode111, listNode222));//[1,1,2,3,4,4]

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            List<Integer> list = new ArrayList<>();
            ListNode temp = this;
            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
            return JSONObject.toJSONString(list);
        }
    }

}
