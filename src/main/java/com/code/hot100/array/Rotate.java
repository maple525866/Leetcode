package com.code.hot100.array;

import java.util.Arrays;

/**
 * @author maple
 * @Description 189.轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * @createTime:2025-11-28 10:57
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(new Rotate().rotate(nums, k)));
    }

    public int[] rotate(int[] nums, int k) {
        // k有可能超过nums.length 但超过多少轮都是会回到起点再次进行轮转 即如果满足k == nums.length就是完整一轮不变
        int count = k % nums.length;

        int[] clone = new int[nums.length];

        // 1.做一个深拷贝
        for (int i = 0; i < nums.length; i++) {
            clone[i] = nums[i];
        }
        // 2. 将复制数组的内容按顺序覆盖到原数组
        for (int i = nums.length - count,j = 0; i < nums.length; i++,j++) {
            nums[j] = clone[i];
        }

        for(int i = count,j = 0; i < nums.length; i++,j++) {
            nums[i] = clone[j];
        }

        return nums;
    }
}
