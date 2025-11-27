package com.code.hot100.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple
 * @Description 438. 找到字符串中所有字母异位词
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词
 * &#064;createTime:2025-11-27  16:20
 */
public class FindAnagrams {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] sInt = new int[26];
        int[] pInt = new int[26];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            pInt[p.charAt(i) - 'a']++;
            sInt[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sInt, pInt)) res.add(0);

        for(int i = 0; i < s.length() - p.length(); i++){
            sInt[s.charAt(i) - 'a']++;
            sInt[s.charAt(i + p.length()) - 'a']--;

            if(Arrays.equals(sInt, pInt)) res.add(i + 1);
        }

        return res;
    }
}
