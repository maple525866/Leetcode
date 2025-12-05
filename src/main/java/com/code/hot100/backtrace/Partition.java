package com.code.hot100.backtrace;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maple
 * @Description 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 * @createTime:2025-12-05 21:01
 */
public class Partition {
    List<List<String>> res = new ArrayList<>();
    Deque<String> list = new LinkedList<>();

    public static void main(String[] args) {
        Partition partition = new Partition();
        List<List<String>> res = partition.partition("aab");
        System.out.println(res.toString());
    }

    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();
        backTrace(arr,0);

        return res;
    }

    private void backTrace(char[] arr, int count) {
        if(count == arr.length) {
            res.add(new ArrayList<>(list));
        }

        for(int i = count; i < arr.length; i++) {
            // 如果这段的字符串属于回文串,就将其放进list中
            if(isPalindrome(arr,count,i)){
                list.add(new String(arr,count,i - count + 1));
                backTrace(arr,i + 1);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while(left < right) {
            if(arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
