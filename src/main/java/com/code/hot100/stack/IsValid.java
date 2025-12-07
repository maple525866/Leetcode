package com.code.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;
/**
 * @author maple
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 *
 * 输入：s = "()"
 *
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 *
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 *
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([])"
 *
 * 输出：true
 *
 * 示例 5：
 *
 * 输入：s = "([)]"
 *
 * 输出：false
 * @createTime:2025-12-07 15:35
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "([)]";
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid(s));
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int n = s.length();
        int i = 0;
        while(i < n){
            char c = s.charAt(i);
            i++;

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }

            if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()) return false;
                char d = stack.pop();
                if(d == '(' && c == ')'){
                    continue;
                }else if(d == '{' && c == '}'){
                    continue;
                }else if(d == '[' && c == ']'){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
