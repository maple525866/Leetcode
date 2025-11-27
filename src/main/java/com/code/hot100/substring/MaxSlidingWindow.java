package com.code.hot100.substring;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 239.滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * @createTime:2025-11-27 19:20
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(nums, k)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];

        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for(int j = 0, i = 1 - k; j < nums.length; i++,j++){

            // 当下标1及以后才需要不断判断当前最大值是否需要去除(左边界)
            if(i > 0 && nums[i - 1] == queue.peekFirst()){
                queue.removeFirst();
            }

            // 去除队列中比最新数据要小的数据(最大堆，优先队列)
            while(!queue.isEmpty() && nums[j] > queue.peekLast()){
                queue.removeLast();
            }

            // 添加该元素到优先队列中
            queue.addLast(nums[j]);

            //每次就可以取队头元素即可
            if(i >= 0) res[i] = queue.peekFirst();
        }

        return res;
    }
}
