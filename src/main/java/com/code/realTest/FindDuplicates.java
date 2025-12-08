package com.code.realTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple
 * @Description 442. 数组中重复的数据
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 最多两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间（不包括存储输出所需的空间）的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[]
 *
 * @createTime:2025-12-08 21:13
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        FindDuplicates findDuplicates = new FindDuplicates();
        List<Integer> duplicate = findDuplicates.findDuplicate(arr);
        System.out.println(duplicate);
    }

    public List<Integer> findDuplicate(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if(nums[x - 1] > 0){
                nums[x - 1] = -nums[x - 1];
            }else{
                res.add(x);
            }
        }
        return res;
    }
}
