package com.code.hot100.array;

/**
 * @author maple
 * @Description 41.缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * @createTime:2025-11-28 17:11
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        System.out.println(new FirstMissingPositive().firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            // 如果当前学生的学号在 [1,n] 中，但（真身）没有坐在正确的座位上
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // nums[i] - 1该坐下的对应的座位号
                int j = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 找第一个学号与座位编号不匹配的学生
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 所有学生都坐在正确的座位上的情况
        return n + 1;
    }
}
