package org.example.topinterview150;

import java.util.HashSet;

public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int lowest = n & 1;
            if (lowest == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        //输入：n = 11
        //输出：3
        System.out.println(new HammingWeight().hammingWeight(11));
        //输入：n = 128
        //输出：1
        System.out.println(new HammingWeight().hammingWeight(128));
        //输入：n = 2147483645
        //输出：30
        System.out.println(new HammingWeight().hammingWeight(2147483645));
    }
}
