package com.code.hot100.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author maple
 * @Description 295. 数据流的中位数
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * 示例 1：
 *
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 *
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * @createTime:2025-12-08 15:33
 */
public class MedianFinder {
    Queue<Integer> left;
    Queue<Integer> right;
    public MedianFinder(){
        // 最大堆[1,2,3] -> 3
        left = new PriorityQueue<>((a,b)->b-a);
        // 最小堆[4,5] -> 4
        right = new PriorityQueue<>((a,b)->a-b);
    }

    public void addNum(int num){
        //保证 left 的大小和 right 的大小尽量相等。规定：在有奇数个数时，left 比 right 多 1 个数
        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }

        // 平衡堆的大小
        if(left.size() > right.size() + 1){
            right.offer(left.poll());
        }else if(right.size() > left.size()){
            left.offer(right.poll());
        }
    }

    public double findMedian(){
        if(left.size() > right.size()){
            return left.peek();
        }else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
