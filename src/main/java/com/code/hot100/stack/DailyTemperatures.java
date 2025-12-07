package com.code.hot100.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * @createTime:2025-12-07 19:15
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures.dailyTemperatures(arr);
        System.out.println(Arrays.toString(res));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 维护一个单调栈，栈顶是最小元素,存储下标
        Deque<Integer> stack = new LinkedList<>();
        int[] arr = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            int temperature = temperatures[i];

            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int index = stack.pop();
                arr[index] = i - index;
            }

            stack.push(i);
        }
        return arr;
    }
}
