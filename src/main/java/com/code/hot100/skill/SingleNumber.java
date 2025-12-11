package com.code.hot100.skill;

/**
 * @author maple
 * @Description 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 *
 * 输出：1
 *
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 *
 * 输出：4
 *
 * 示例 3 ：
 *
 * 输入：nums = [1]
 *
 * 输出：1
 * @createTime:2025-12-11 16:11
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4,1,2,1,2};

        int i = singleNumber.singleNumber(nums);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        // 利用异或的性质来解决,只有不同的时候才是自己
        for (int num : nums) {
            res ^= num;
        }

        // 成对的数异或为0，最后只剩那个唯一的数
        return res;
    }
}
