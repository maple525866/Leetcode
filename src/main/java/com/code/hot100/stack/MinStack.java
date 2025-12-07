package com.code.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description
 * @createTime:2025-12-07 16:11
 */
public class MinStack {
    private Deque<Integer> stack;
    private int min;
    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val < min){
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        int size = stack.size();
        int[] arr = new int[size];
        min = Integer.MAX_VALUE;
        for(int i = size - 1; i >= 0; i--){
            arr[i] = stack.pop();
            if(min > arr[i]){
                min = arr[i];
            }
        }

        for(int i = 0; i < size; i++){
            stack.push(arr[i]);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
