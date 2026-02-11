package com.code.realtest.stack;

/**
 * @author maple
 * @Description 402. 移掉 K 位数字 单调栈 + 贪心
 *给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * @createTime:2026-02-11 17:09
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if(k > num.length()){
            return "0";
        }

        StringBuilder stack = new StringBuilder();

        for(char c : num.toCharArray()){

            while(k > 0 && stack.length() > 0 && c < stack.charAt(stack.length() - 1)){
                // 当还能删除（k > 0），且栈非空，且当前数字小于栈顶
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(c);

        }

        // 如果还有剩余的 k，从末尾删（因为此时栈内是非递减的）
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // 去除前导零
        int start = 0;
        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }

        // 如果全被删光了，返回 "0"
        if (start == stack.length()) {
            return "0";
        }

        return stack.substring(start);
    }
}
