package com.code.hot100.substring;

/**
 * @author maple
 * @Description 560.和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * @createTime:2025-11-27 16:38
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            int store = 0;
            for(int j = i; j < nums.length; j++) {
                store += nums[j];
                if(store == k) res++;
            }
        }

        return res;
    }
}
