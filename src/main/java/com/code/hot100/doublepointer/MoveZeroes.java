package com.code.hot100.doublepointer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author maple
 * @Description
 * @createTime:2025-07-23 18:43
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        moveZeroes(arr);
        System.out.println("Your array is: " + Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                fast++;
                slow++;
            }else {
                fast++;
            }
        }
    }
}
