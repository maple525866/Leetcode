package com.code.hot100.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author maple
 * @Description
 * @createTime:2025-07-23 16:13
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("result = " + longestConsecutive(nums));
        System.out.println(Arrays.toString(nums));
        scanner.close();
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for(int num : set) {
            if(!set.contains(num-1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum+1)) {
                    currentNum++;
                    currentLength++;
                }
                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
}
