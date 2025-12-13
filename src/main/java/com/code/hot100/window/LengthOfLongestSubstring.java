package com.code.hot100.window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @createTime:2025-12-13 21:50
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Deque<Character> queue = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if(queue.contains(s.charAt(i))) {
                while(!queue.isEmpty() && queue.contains(s.charAt(i))) {
                    queue.removeFirst();
                }
                queue.addLast(s.charAt(i));
            }else {
                queue.addLast(s.charAt(i));
            }
            res = Math.max(res, queue.size());
        }

        return res;
    }
}
