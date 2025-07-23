package com.code.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author maple
 * @Description
 * @createTime:2025-07-08 20:05
 */
public class TwoSum {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = myScanner.nextInt();
        }

        int target = myScanner.nextInt();


        TwoSum twoSum = new TwoSum();

        int[] res = twoSum.twoSum(nums, target);
        System.out.println("res = " + Arrays.toString(res));
    }

    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
