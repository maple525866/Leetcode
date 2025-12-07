package com.code.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author maple
 * @Description
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 测试用例保证输出的长度不会超过 105。
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @createTime:2025-12-07 17:01
 */
public class DecodeString {
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = decodeString.decodeString("3[a]2[bc]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Deque<Integer> stack_multi = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();

        for(Character c : s.toCharArray()) {
            if(c == '['){
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int count = stack_multi.poll();

                for(int i = 0; i < count; i++){
                    tmp.append(res);
                }

                res = new StringBuilder(stack_res.pop() + tmp.toString());
            }else if(c >= '0' && c <= '9'){
                multi = multi * 10 + c - '0';
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
