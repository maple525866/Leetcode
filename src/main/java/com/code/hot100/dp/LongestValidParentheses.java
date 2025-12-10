package com.code.hot100.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
 *
 * 左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
 *示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 * @createTime:2025-12-10 20:36
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;

        // 1.栈,存储下标,用来方便下标相减得到长度
        Deque<Integer> stack = new LinkedList<>();

        // 2.作为初始边界
        stack.push(-1);
        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(i);
            }else{
                // 3.弹出匹配的"(",或者遇到不合法的")",则弹出旧的边界
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                // 4.当前合法的“)”的下标减去边界下标,即是该有效括号子串的长度
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
