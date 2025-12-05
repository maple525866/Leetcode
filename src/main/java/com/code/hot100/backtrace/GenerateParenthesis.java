package com.code.hot100.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple
 * @Description 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * @createTime:2025-12-05 18:17
 */
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        backTrace(0,0,n,new StringBuilder());

        return res;
    }

    private void backTrace(int open, int close, int n, StringBuilder sb) {
        if(n * 2 == sb.length()) {
            res.add(sb.toString());
        }

        if(open < n) {
            sb.append('(');
            backTrace(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open) {
            sb.append(')');
            backTrace(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
