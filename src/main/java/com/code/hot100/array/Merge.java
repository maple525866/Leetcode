package com.code.hot100.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple
 * @Description
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 *
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间
 * @createTime:2025-11-27 21:50
 */
public class Merge {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        Merge merge = new Merge();
        int[][] ints = merge.merge(arr);
        // 数组打印方法
        // 一维数组：Arrays.toString(arr)
        // 多维数组：Arrays.deepToString(arr)
        System.out.println(Arrays.deepToString(ints));
    }

    public int[][] merge(int[][] intervals) {
        Deque<int[]> queue = new LinkedList<>();
        Arrays.sort(intervals,(o1, o2) -> Integer.compare(o1[0], o2[0]));

        queue.addLast(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= queue.peekLast()[1]) {
                int start = queue.peekFirst()[0];
                int end = Math.max(intervals[i][1], queue.peekLast()[1]);
                queue.removeLast();
                queue.addLast(new int[]{start, end});
            }else{
                queue.addLast(intervals[i]);
            }
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
