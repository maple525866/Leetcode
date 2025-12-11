package com.code.hot100.skill;

import java.util.Arrays;

/**
 * @author maple
 * @Description 31. 下一个排列（最好记住）
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * @createTime:2025-12-11 19:44
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {1,2,3};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1.找“下降点” —— 从右往左找第一个 nums[i] < nums[i+1]
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        // 2.如果 i >= 0，就在右边找 刚好比 nums[i] 大的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 3.原地交换这两个数
            swap(nums,i,j);
        }
        // 4. i+1 到末尾 反转（变成升序）
        reverse(nums,i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
