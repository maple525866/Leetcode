package com.code.realtest.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author maple
 * @Description 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素 最大和。
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * @createTime:2025-12-08 20:04
 */
public class MaxSumDivThree {
    public static void main(String[] args) {
        int[] arr = {3,6,5,1,8};
        MaxSumDivThree maxSumDivThree = new MaxSumDivThree();
        System.out.println(maxSumDivThree.maxSumDivThree(arr));
    }

    /**
     * 当res % 3 != 0时，有可能余1或者2,我们需要去掉某些数来使当前的最大和不再有余数
     * @param nums
     * @method 贪心
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int res = 0;

        for(int i : nums){
            res += i;
        }

        if(res % 3 == 0) return res;

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        for(int i : nums){
            if(i % 3 == 1) l1.add(i);
            if(i % 3 == 2) l2.add(i);
        }

        Collections.sort(l1);
        Collections.sort(l2);

        // 因为res % 3有可能 == 1也可以 == 2,如果等于2就swap一下就行,这样就统一了两种不同的情况
        if(res % 3 == 2){
            ArrayList<Integer> tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        // 最大和有可能是减掉一个 % 3 == 1 或者 两个 % 3 == 2,或者反转来的,上面已经通过交换将两种情况统一了
        int ans = l1.isEmpty() ? 0 : res - l1.get(0);
        if(l2.size() > 1){
            ans = Math.max(ans,res - l2.get(0) - l2.get(1));
        }

        return ans;
    }
}
