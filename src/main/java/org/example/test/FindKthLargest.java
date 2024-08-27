package org.example.test;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                Integer min = queue.peek();
                if (num > min) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new FindKthLargest().findKthLargest(nums, 2));//5
        System.out.println(new FindKthLargest().findKthLargest(nums, 3));//4
    }


}
