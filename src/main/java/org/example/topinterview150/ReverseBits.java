package org.example.topinterview150;

public class ReverseBits {

    public int reverseBits(int n) {
        //n=12345678,依次将最低位摘出来，存到最高位（使用另一个数m来存）
        int m = 0;
        int count = 32;
        for (int i = 0; i < count; i++) {
            //1.先得到最低位：8
            int lowest = n & 1;
            //2.将最低位8存到m的最高位：80000000->87000000->87600000
            m = m | (lowest << 31 - i);
            //3.将剩下31位右移：01234567->001234546->00012345
            n = n >>> 1;
            //4.重复上面的步骤
        }
        //5.移完32位后，返回m的值
        return m;
    }

    public static void main(String[] args) {
        //输入：n = 00000010100101000001111010011100
        //输出：964176192 (00111001011110000010100101000000)
        int n = 0b00000010100101000001111010011100;
        int i = new ReverseBits().reverseBits(n);
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }
}
