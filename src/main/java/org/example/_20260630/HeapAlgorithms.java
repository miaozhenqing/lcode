package org.example._20260630;

import org.example.CommonUtil;
import org.example.test.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author mzq
 * @date 2026/6/30 14:11
 */
public class HeapAlgorithms {


    class Heap {

        private int[] arr;
        private int size;

        public Heap(int[] input) {
            if (input == null) {
                this.arr = new int[0];
                this.size = 0;
                return;
            }

            this.arr = input;
            this.size = input.length;

            buildMaxHeap();
        }

        private void buildMaxHeap() {
            for (int i = size / 2 - 1; i >= 0; i--) {
                siftDown(i);
            }
        }

        private void siftDown(int i) {
            while (true) {

                int largest = i;

                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < size && arr[left] > arr[largest]) {
                    largest = left;
                }

                if (right < size && arr[right] > arr[largest]) {
                    largest = right;
                }

                if (largest == i) {
                    break;
                }

                CommonUtil.swap(arr, i, largest);
                i = largest;
            }
        }


        private void siftUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;

                if (arr[i] > arr[parent]) {
                    CommonUtil.swap(arr, i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        public void offer(int v) {
            if (size == arr.length) {
                throw new IllegalStateException("Heap is full");
            }
            arr[size] = v;
            size++;
            siftUp(size - 1);
        }

        public Integer poll() {
            if (size == 0) {
                return null;
            }

            int v = arr[0];

            size--;

            if (size > 0) {
                arr[0] = arr[size];
                siftDown(0);
            }

            return v;
        }
    }


    //=================sort===================//
    public void heapSort(int[] arr) {
        int n = arr.length;
        // 1) 建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }

        // 2) 排序：堆顶交换到末尾，堆大小-1，再下沉
        for (int heapSize = n - 1; heapSize > 0; heapSize--) {
            CommonUtil.swap(arr, 0, heapSize);
            siftDown(arr, 0, heapSize);
        }

    }

    private void siftDown(int[] arr, int i, int size) {
        while (true) {
            int left = (i * 2) + 1;
            int right = (i * 2) + 2;
            int max = i;
            if (left < size && arr[left] > arr[max]) {
                max = left;
            }
            if (right < size && arr[right] > arr[max]) {
                max = right;
            }
            if (max == i) {
                break;
            }
            CommonUtil.swap(arr, max, i);
            i = max;
        }
    }

    //=================top k===================//
    private void topK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int value : arr) {
            if (queue.size() < k) {
                queue.add(value);
            } else {
                if (queue.peek() < value) {
                    queue.poll();
                    queue.offer(value);
                }
            }
        }
    }

    //=================topKFrequent====出现次数最多的前N个==============//
    private void topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            Integer oldCount = map.getOrDefault(value, 0);
            map.put(value, oldCount + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else {
                Integer count = map.get(queue.peek());
                if (entry.getValue() < count) {
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }
    }

    //=================mergeKLists====合并k个有序链表==============//
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(l -> l.val));
        for (ListNode list : lists) {
            queue.offer(list);
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    //=================数据流的中位数====数据流的中位数==============//
    class MedianFinder {

        // 构造方法
        public MedianFinder() {
        }

        // 添加一个数
        public void addNum(int num) {
        }

        // 返回中位数
        public double findMedian() {
            return 0;
        }
    }


}