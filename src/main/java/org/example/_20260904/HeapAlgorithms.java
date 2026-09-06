package org.example._20260904;

import org.example.common.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HeapAlgorithms {

    class MinHeap {
        private int[] arr;
        //实际数量
        private int size;

        public MinHeap(int[] input) {
            this.arr = Arrays.copyOf(input, input.length);
            this.size = input.length;
            heapify();
        }

        public void insert(int val) {
            arr[size] = val;
            size++;
            swim(size - 1);
        }

        private void swim(int i) {
            while (i > 0 && arr[(i - 1) / 2] > arr[i]) {
                CommonUtil.swap(arr, (i - 1) / 2, i);
                i = (i - 1) / 2;
            }
        }

        private int poll() {
            int poll = arr[0];
            //最后放到堆顶；下沉；size变动
            CommonUtil.swap(arr, 0, size - 1);
            size--;
            sink(0);
            return poll;
        }

        private void sink(int i) {
            while (2 * i + 1 < size) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                //选值更小的节点
                int smaller = left;
                if (right < size && arr[right] < arr[smaller]) {
                    smaller = right;
                }
                //如果比子节点更大，则交换
                if (arr[i] > arr[smaller]) {
                    CommonUtil.swap(arr, i, smaller);
                    i = smaller;
                } else {
                    break;
                }
            }
        }

        // 从无序数组构建小顶堆
        public void heapify() {
            // 1. 找到最后一个非叶子节点的下标
            // 2. 从该下标开始，往前遍历到 0，对每个节点执行 sink
            for (int j = (size - 2) / 2; j >= 0; j--) {
                sink(j);
            }
        }

    }

    //1,2,3,4,5,6  3
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }






    //最小会议室2
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        for (int[] interval : intervals) {
            //queue存正在使用的，如果不用了，就空出来
            while (!queue.isEmpty() && queue.peek() <= interval[0]) {
                queue.poll();
            }
            queue.offer(interval[1]);
            max = Math.max(max, queue.size());
        }
        return max;
    }


}
