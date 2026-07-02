package org.example.common;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode temp = this;
        while (temp != null) {
            if (visitedNodes.contains(temp)) {
                list.add(null);
                break;
            }
            visitedNodes.add(temp);
            list.add(temp.val);
            temp = temp.next;
        }
        return list.toString();
    }
}
