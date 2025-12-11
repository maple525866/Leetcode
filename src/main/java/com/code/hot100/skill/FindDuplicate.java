package com.code.hot100.skill;

import java.util.HashSet;
import java.util.Set;

/**
 * @author maple
 * @Description
 * @createTime:2025-12-11 20:50
 */
public class FindDuplicate {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return 0;
    }
}
