package com.code.hot100.backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author maple
 * @Description 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 * @createTime:2025-12-04 20:40
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = {1,2,3};
        List<List<Integer>> l = permute.permute(nums);
        System.out.println(l);
    }

    public List<List<Integer>> permute(int[] nums) {
        for(int i : nums){
            list.add(i);
        }

        backTrace(nums,0,nums.length);

        return res;
    }

    private void backTrace(int[] nums, int count, int n) {
        if(count == n) {
            res.add(new ArrayList<>(list));
        }

        for(int i = count; i < n; i++){
            Collections.swap(list,count,i);
            backTrace(nums,count+1,n);
            Collections.swap(list,count,i);
        }
    }
}
