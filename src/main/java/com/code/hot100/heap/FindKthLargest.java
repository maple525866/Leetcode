package com.code.hot100.heap;

import java.util.PriorityQueue;

/**
 * @author maple
 * @Description 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * @createTime:2025-12-07 20:06
 */
public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] arr = {3,2,1,5,6,4};
        int res = findKthLargest.findKthLargest(arr, 2);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        // 构建一个最小堆,堆头就是第K个最大值
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int i = 0; i < nums.length; i++) {
            if(queue.size() >= k){
                if(queue.peek() < nums[i]){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }else{
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
