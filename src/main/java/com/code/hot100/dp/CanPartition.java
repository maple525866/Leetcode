package com.code.hot100.dp;

/**
 * @author maple
 * @Description
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * @createTime:2025-12-10 16:02
 */
public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        int[] nums = {1,5,11,5};
        System.out.println(canPartition.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int target = 0;
        int max = Integer.MIN_VALUE;

        //如果数组元素个数少于2个，是无法划分子集的
        if(n <= 1) return false;

        for(int i : nums){
            sum += i;
            max = Math.max(max, i);
        }

        target = sum / 2;

        //总和不是偶数则无法分成两个相等的子集
        if(sum % 2 != 0) return false;
        //最大元素如果大于总和一半，则无法划分成两个相等的子集
        if(max > target) return false;

        //dp[i] = 能存在一个子集其元素之和恰好等于i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int i = 1; i < n; i++){
            int num = nums[i];
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] | dp[j - num];
            }
        }

        return dp[target];
    }
}
