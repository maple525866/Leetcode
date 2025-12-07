package com.code.hot100.binarysearch;

import java.util.Arrays;

/**
 * @author maple
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * @createTime:2025-12-06 15:36
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(arr, 7)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        // 1.寻找第一个位置
        int start = helper(nums,target);

        // 2.如果所有元素都 < target(最右边 + 1) || start下标对应的元素(target所在位置或者target应插入的地方)不等于target
        // 符合这种情况则说明数组没这个元素
        if(start == nums.length || nums[start] != target){
            return res;
        }

        // 3.找到比target 大1的元素应插入的下标位置,再减一则就是最右边target的下标
        int end = helper(nums,target + 1) - 1;

        res[0] = start;
        res[1] = end;

        return res;
    }

    /**
     * 正常二分查找
     * @param nums
     * @param target
     * @return target的下标或者应插入的下标
     */
    private int helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] < target){
                left = mid + 1;
            }else {
                // 即使target == nums[right] 那么也要再让right变动一次,目的是让right < left,这样left对应的位置就会是target的下标或者需要填入的下标
                right = mid - 1;
            }
        }

        return left;
    }
}
