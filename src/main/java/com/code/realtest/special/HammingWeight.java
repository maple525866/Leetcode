package com.code.realtest.special;

/**
 * @author maple
 * @Description int类型的十位数，转换成32位的二进制，数里面有多少个1。负数则用补数(tme)
 * tme秋招一面题目
 * @createTime:2026-09-23 23:15
 */
public class HammingWeight {
    public static void main(String[] args) {
        int res = hammingWeight(3);
        System.out.println(res);
    }
    public static int hammingWeight(int n) {
        int count = 0;
        // 使用无符号右移，保证负数左边补0
        while (n != 0) {
            // 判断最后一位是否为1
            if ((n & 1) == 1) {
                count++;
            }
            // 无符号右移一位
            n >>>= 1;
        }
        return count;
    }
}
