package com.code.realtest.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author maple
 * @Description 有效的括号(变式)
 * 在有括号嵌套的情况下，必须按照数学中常见的“层级顺序”来嵌套
 * @createTime:2025-12-14 21:57
 */
public class ValidNestedParentheses {
    public static void main(String[] args) {
        // 合法
        System.out.println(isValid("()"));        // true
        System.out.println(isValid("{}"));        // true
        System.out.println(isValid("[]"));        // true
        System.out.println(isValid("{[()]}"));    // true
        System.out.println(isValid("{()}"));      // true
        System.out.println(isValid("[()]"));      // true

        // 非法
        System.out.println(isValid("({})"));      // false
        System.out.println(isValid("[(])"));      // false
        System.out.println(isValid("([{}])"));    // false
        System.out.println(isValid("{[}]"));      // false
        System.out.println(isValid("((("));       // false
        System.out.println(isValid(""));          // true（空串合法）
    }

    public static boolean isValid(String s) {
        // 定义左括号的层级：{ 最外层（2），[ 中间（1），( 最内层（0）
        Map<Character, Integer> level = new HashMap<>();
        level.put('{', 2);
        level.put('[', 1);
        level.put('(', 0);

        // 右括号到左括号的映射
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (level.containsKey(c)) {
                // 当前是左括号
                if (!stack.isEmpty() && level.get(c) > level.get(stack.peek())) {
                    // 新左括号层级比栈顶更高（更“外层”），说明试图用内层包外层 → 非法
                    return false;
                }
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                // 当前是右括号
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            } else {
                // 非括号字符（题目通常只含括号，但为健壮性可加）
                return false;
            }
        }

        return stack.isEmpty();
    }
}
