package com.code.hot100.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maple
 * @Description 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * @createTime:2025-12-04 22:09
 */
public class LetterCombinations {
    Map<Character,String> map = new HashMap<Character,String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");


        }
    };
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        char[] ch = digits.toCharArray();
        backTrace(ch,0,new StringBuilder());

        return res;
    }

    private void backTrace(char[] ch, int count,StringBuilder sb){
        if(count == ch.length){
            res.add(sb.toString());
            return;
        }
        char key = ch[count];
        String value = map.get(key);
        int len = value.length();

        for(int i = 0; i < len; i++){
            sb.append(value.charAt(i));
            backTrace(ch,count + 1,sb);
            sb.deleteCharAt(count);
        }
    }
}
