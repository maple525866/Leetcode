package com.code.hot100.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maple
 * @Description 76.最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * @createTime:2025-11-27 20:36
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));
    }
    // todo 这个要再次练习
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0,right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                // window 哈希表只记录那些也存在于 need 中的字符的频次
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            while(valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
