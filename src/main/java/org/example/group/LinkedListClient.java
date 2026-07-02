package org.example.group;

import org.example.common.CommonUtil;
import org.example.common.DLinkedNode;
import org.example.common.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 链表相关算法
 */
public class LinkedListClient {
    public static void main(String[] args) {
        //环形链表
        //输入：head = [3,2,0,-4], pos = 1
        //输出：true
        //解释：链表中有一个环，其尾部连接到第二个节点。
//        ListNode node = createListWithCycle(new int[]{3, 2, 0, -4}, 1);
//        System.out.println(hasCycle(node));
//        System.out.println(hasCycleAndReturn(node));

        //合并两个有序列表
        //输入：l1 = [1,2,4], l2 = [1,3,4]
        //输出：[1,1,2,3,4,4]
//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(4);
//        ListNode node2 = new ListNode(1);
//        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(4);
//        System.out.println(mergeTwoLists(node1, node2));

        //随机链表的复制
        //输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        //输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//        ListNode node1 = new ListNode(7);
//        node1.next = new ListNode(13);
//        node1.next.next = new ListNode(11);
//        node1.next.next.next = new ListNode(10);
//        node1.next.next.next.next = new ListNode(1);
//        ListNode node2 = copyRandomList(node1);
//        System.out.println(node2);

        //反转列表2
        //输入：head = [1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(reverseBetween(node1, 2, 4));

        //反转链表，返回头尾指针
        //[1,2,3,4,5]
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(reverse(node1));

        //K 个一组翻转链表
//        ListNode tailK = new ListNode(5);
//        ListNode headK = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, tailK))));
//        System.out.println(reverseKGroup(headK, 2));

        //删除链表的倒数第N个节点
        //输入：head = [1,2,3,4,5], n = 2
        //输出：[1,2,3,5]
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(removeNthFromEnd(node1, 2));//[1,2,3,5]
//        //输入：head = [1], n = 1
//        //输出：[]
//        node1 = new ListNode(1);
//        System.out.println(removeNthFromEnd(node1, 1));//[]
//        //输入：head = [1,2], n = 1
//        //输出：[1]
//        node1 = new ListNode(1, new ListNode(2));
//        System.out.println(removeNthFromEnd(node1, 1));//[1]

        //删除排序链表中的重复元素 II
        //输入：head = [1,2,3,3,4,4,5]
        //输出：[1,2,5]
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//        System.out.println(deleteDuplicates(node1));//[1,2,5]

        //旋转链表
        //输入：head = [1,2,3,4,5], k = 2
        //输出：[4,5,1,2,3]
//        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(rotateRight(node1, 2));
//        //输入：head = [0,1,2], k = 4
//        //输出：[2,0,1]
//        node1 = new ListNode(0, new ListNode(1, new ListNode(2)));
//        System.out.println(rotateRight(node1, 4));//[2,0,1]

        //分隔链表
        //输入：head = [1,4,3,2,5,2], x = 3
        //输出：[1,2,2,4,3,5]
//        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
//        System.out.println(partition(node1, 3));
//        //输入：head = [2,1], x = 2
//        //输出：[1,2]
//        node1 = new ListNode(2, new ListNode(1));
//        System.out.println(partition(node1, 2));

        //LRU


    }



    /**
     * 分隔链表
     */
    public static ListNode partition(ListNode head, int x) {
        //输入：head = [1,4,3,2,5,2], x = 3
        //输出：[1,2,2,4,3,5]
        ListNode small = new ListNode(-1);
        ListNode smallCur = small;
        ListNode large = new ListNode(-1);
        ListNode largeCur = large;
        while (head != null) {
            if (head.val < x) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                largeCur.next = head;
                largeCur = largeCur.next;
            }
            head = head.next;
        }
        largeCur.next = null;
        smallCur.next = large.next;
        return small.next;
    }

    /**
     * 旋转链表
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        //头尾相连
        tail.next = head;
        //如果移动len,相当于没有移动，重新计算有效的移动数k
        k = k % len;
        //新的头结点尾len-k，这里从原来的头节点head，往后找到len-k-1处，再下一个节点就是新的头结点
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }


    /**
     * 删除排序链表中的重复元素 II
     */
    public static ListNode deleteDuplicates(ListNode head) {
        //[1,2,3,3,3,4,4,5]
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode current = head;

        while (current != null) {
            // 如果当前节点有重复
            //[1,2,[3],3,3,4,4,5]
            if (current.next != null && current.next.val == current.val) {
                //一直找到最后一个重复节点
                ListNode next = current.next;
                while (next != null && next.val == current.val) {
                    next = next.next;
                }
                pre.next = next;
                current = next;
            } else {
                // 如果没有重复，移动 prev 和 current
                pre = current;
                current = current.next;
            }
        }
        return dummy.next;
    }

    /**
     * 删除链表的倒数第 N 个结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    /**
     * K 个一组翻转链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        //1-2-3-4-5    2
        ListNode tail = head;
        List<ListNode[]> nodes = new ArrayList<>();
        ListNode tailTmp = null;
        boolean isBread = false;
        while (head != null) {
            if (isBread) {
                break;
            }
            for (int i = 0; i < k; i++) {
                //链表结尾
                if (tail == null) {
                    if (i < k - 1) {
                        //不够分
                        tailTmp = head;
                        isBread = true;
                        break;
                    }
                } else {//非链表结尾
                    //刚好够分
                    if (i == k - 1) {
                        ListNode nextHead = tail.next;
                        ListNode[] res = reverse(head, tail);
                        nodes.add(res);
                        //先断开
                        head = nextHead;
                        tail = nextHead;
                    } else {
                        tail = tail.next;
                    }
                }
            }
        }
        //再把每个链表拼接起来，包括最后一个没有反转的tailTmp
        for (int i = 0; i < nodes.size() - 1; i++) {
            ListNode[] pre = nodes.get(i);
            ListNode[] post = nodes.get(i + 1);
            pre[1].next = post[0];
        }
        if (tailTmp != null) {
            ListNode[] lastOne = nodes.get(nodes.size() - 1);
            lastOne[1].next = tailTmp;
        }
        ListNode firstOne = nodes.get(0)[0];
        return firstOne;
    }


    private static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode post = tail.next;
        ListNode pre = null;
        ListNode newHead = head;
        while (head != post) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{tail, newHead};
    }


    /**
     * 反转链表，返回头尾指针
     */
    public static List<ListNode> reverse(ListNode head) {
        // 1-2-3-4-5
        ListNode newTail = head;
        ListNode pre = null;
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            if (head != null) {
                newHead = head;
            }
        }
        return CommonUtil.listOf(newHead, newTail);
    }

    /**
     * 反转链表 II
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode pre = d;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return d.next;
    }


    /**
     * 随机链表的复制
     */
    static Map<ListNode, ListNode> cachedNode = new HashMap<ListNode, ListNode>();

    public static ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            ListNode newNode = new ListNode(head.val);
            cachedNode.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    /**
     * 合并两个有序列表
     */
    public static ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode cur = new ListNode();
        ListNode head = cur;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return head.next;
    }

    /**
     * 环形链表
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;  // 让 fast 从 head 开始
        ListNode slow = head;  // slow 从 head 开始
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否有环，并且返回环的入口节点
     */
    public static List hasCycleAndReturn(ListNode head) {
        if (head == null || head.next == null) {
            return CommonUtil.listOf(false, null);
        }
        ListNode fast = head;  // 让 fast 从 head 开始
        ListNode slow = head;  // slow 从 head 开始
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 检测到有环，接下来找环的入口节点
                // 将慢指针放回头节点
                slow = head;
                // 让快慢指针一起以每次一步的速度前进，直到它们相遇
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                // 此时 fast 和 slow 相遇在环的入口节点
                return CommonUtil.listOf(true, slow);
            }
        }
        return CommonUtil.listOf(false, null);
    }

    // 创建链表并建立环
    public static ListNode createListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleEntryNode = null;

        // 创建链表
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleEntryNode = current; // 记录环的入口节点
            }
        }

        // 如果pos >= 0，创建环
        if (pos >= 0) {
            current.next = cycleEntryNode; // 将最后一个节点的next指向环的入口节点
        }

        return head;
    }
}
