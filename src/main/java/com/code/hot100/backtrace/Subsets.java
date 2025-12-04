package com.code.hot100.backtrace;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @createTime:2025-12-04 21:30
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }

    private List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,0,nums.length);
        return res;
    }

    private void backTrace(int[] nums, int count, int n) {
        res.add(new ArrayList<>(list));

        for(int i = count; i < n; i++){
            list.addLast(nums[i]);
            backTrace(nums,i + 1,n);
            list.removeLast();
        }
    }
}
