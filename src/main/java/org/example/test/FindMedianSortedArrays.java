package org.example.test;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int t = nums1.length + nums2.length;    //总长度
        if(t % 2 == 0)  //总长度为偶数
            return (f(nums1, 0, nums2, 0, t / 2) + f(nums1, 0, nums2, 0, t / 2 + 1)) / 2.0; //中位数为两个数的平均数
        else
            return f(nums1, 0, nums2, 0, t / 2 + 1);//中位数为中间那个数
    }
    int f(int[] nums1, int i, int[] nums2, int j, int k) {
        if(nums1.length - i > nums2.length - j) //我们使得剩余长度小的放在nums1；如果nums1的剩余长度大于nums2，则交换位置
            return f(nums2, j, nums1, i, k);
        if(nums1.length == i) //nums1已经全部遍历完，那么中位数肯定再nums2的第j+k-1个
            return nums2[j + k - 1];
        if(k == 1)  //如果k等于1，就代表是第一个数，那么我们就直接返回两个数组中较小的那个数
            return Math.min(nums1[i], nums2[j]);
        int si = Math.min(i + k / 2, nums1.length);//取nums1第剩余区间的中间那个数
        int sj = j + k / 2; //取nums2剩余区间中间那个数
        if(nums1[si - 1] > nums2[sj - 1])   //代表可以排除nums2中sj左半边的数
            return f(nums1, i, nums2, sj, k - k / 2);
        else
            return f(nums1, si, nums2, j, k - (si - i));//排除nums1左半边的数
    }
}
