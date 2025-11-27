package com.code.hot100.array;

/**
 * @author maple
 * @Description 53.最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * @createTime:2025-11-27 21:21
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int res = 0;
        int store = 0;
        for (int i = 0; i < nums.length; i++) {
            store += nums[i];
            res = Math.max(res,store);

            if(store < 0){
                store = 0;
            }
        }

        return res;
    }
}
