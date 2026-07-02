package org.example.common;

public class DLinkedNode {
    public int key;
    public int value;
    public DLinkedNode prev;
    public DLinkedNode next;

    public DLinkedNode() {}

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
