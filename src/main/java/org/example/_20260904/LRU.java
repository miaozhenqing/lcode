package org.example._20260904;

import org.example.common.DLinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mzq
 * @date 2026/9/4 13:54
 */
public class LRU {
    private Map<Integer, DLinkedNode> map;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        DLinkedNode existNode = map.get(key);
        if (existNode != null) {
            existNode.value = value;
            moveToHead(existNode);
        } else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (map.size() > capacity) {
                DLinkedNode node = removeTail();
                map.remove(node.key);
            }
        }
    }

    private void moveToHead(DLinkedNode existNode) {
        removeNode(existNode);
        addToHead(existNode);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;

    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void addToHead(DLinkedNode node) {
        DLinkedNode next = head.next;
        next.prev = node;
        node.next = next;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
}
