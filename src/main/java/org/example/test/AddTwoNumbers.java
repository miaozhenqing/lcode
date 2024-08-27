package org.example.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode data = head;
        boolean overTen = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val+ (overTen ? 1 : 0);
            int result = sum % 10;
            data.next = new ListNode(result);
            overTen = sum / 10 > 0;
            l1 = l1.next;
            l2 = l2.next;
            data = data.next;
        }
        while (l1 != null) {
            int sum = l1.val + (overTen ? 1 : 0);
            int result = sum % 10;
            data.next = new ListNode(result);
            overTen = sum / 10 > 0;
            l1 = l1.next;
            data = data.next;
        }
        while (l2 != null) {
            int sum = l2.val + (overTen ? 1 : 0);
            int result = sum % 10;
            data.next = new ListNode(result);
            overTen = sum / 10 > 0;
            l2 = l2.next;
            data = data.next;
        }
        if (overTen) {
            data.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {

        ListNode listNode111 = new ListNode(3, new ListNode(7));
        ListNode listNode222 = new ListNode(9, new ListNode(2));
        System.out.println(addTwoNumbers(listNode111, listNode222));//[2,0,1]

        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(listNode1, listNode2));//[7,0,8]


        ListNode listNode11 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));//[9,9,9,9,9,9,9]
        ListNode listNode22 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));//[9,9,9,9]
        System.out.println(addTwoNumbers(listNode11, listNode22));//[8,9,9,9,0,0,0,1]


        ListNode listNode1111 = new ListNode(0);
        ListNode listNode2222 = new ListNode(0);
        System.out.println(addTwoNumbers(listNode1111, listNode2222));//[0]


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
