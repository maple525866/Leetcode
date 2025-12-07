package com.code.hot100.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple
 * @Description 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3], k = 2
 *
 * 输出：[1,2]
 *
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 *
 * 输出：[1]
 *
 * 示例 3：
 *
 * 输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 *
 * 输出：[1,2]
 * @createTime:2025-12-07 21:34
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {9,9,9,9,2,2,3,3,3};
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] res = topKFrequent.topKFrequent(arr, 2);
        System.out.println(Arrays.toString(res));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 构建最小堆
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int key : map.keySet()) {
            if(queue.size() >= k){
                if(map.get(key) > map.get(queue.peek())){
                    queue.poll();
                    queue.offer(key);
                }
            }else {
                queue.offer(key);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
