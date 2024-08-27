package org.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (queue.size() < k) {
                    queue.offer(new int[]{sum, i, j});
                } else {
                    if (sum < queue.peek()[0]) {
                        queue.poll();
                        queue.offer(new int[]{sum, i, j});
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (queue.size() != 0) {
            int[] poll = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[poll[1]]);
            list.add(nums2[poll[2]]);
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        if (nums1.length == 0 || nums2.length == 0 || k <= 0) return new ArrayList<>();

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            res.add(Arrays.asList(nums1[pair[1]], nums2[pair[2]]));
            if (pair[2] + 1 < nums2.length) {
                queue.offer(new int[]{nums1[pair[1]] + nums2[pair[2] + 1], pair[1], pair[2] + 1});
            }
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>(k);
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(n, k); i++) {
            queue.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!queue.isEmpty() && result.size() < k) {
            int[] p = queue.poll();
            int index1 = p[1];
            int index2 = p[2];
            result.add(Arrays.asList(nums1[index1], nums2[index2]));
            if (index2 + 1 < m) {
                queue.add(new int[]{nums1[index1] + nums2[index2 + 1], index1, index2 + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        System.out.println(kSmallestPairs.kSmallestPairs3(nums1, nums2, 3));//[1,2],[1,4],[1,6]

        //测试用例:[1,1,2]
        //			[1,2,3]
        //			2
        //	期望结果:[[1,1],[1,1]]
        int[] nums11 = {1, 1, 2};
        int[] nums22 = {1, 2, 3};
        System.out.println(kSmallestPairs.kSmallestPairs3(nums11, nums22, 2));//[[1,1],[1,1]]

        //输入: nums1 = [1,2], nums2 = [3], k = 3
        ////输出: [1,3],[2,3]
        int[] nums111 = {1, 2};
        int[] nums222 = {3};
        System.out.println(kSmallestPairs.kSmallestPairs3(nums111, nums222, 3));//[1,3],[2,3]
    }
}
