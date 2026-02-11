package com.code.realtest.backTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple
 * @Description 784. 字母大小写全排列 回溯
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 *
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * 示例 1：
 *
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 *
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * @createTime:2026-02-11 17:11
 */
public class LetterCasePermutation {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] ch = s.toCharArray();
        backTrace(ch,0);

        return res;
    }

    private void backTrace(char[] ch,int count){
        if(count == ch.length){
            res.add(new String(ch));
            return;
        }

        // 无论是否是字母，都要继续递归（至少走一次）,因为有可能是数字，是数字就接下来走
        backTrace(ch, count + 1);

        if((ch[count] >= 'a' && ch[count] <= 'z') || (ch[count] >= 'A' && ch[count] <= 'Z')){
            // 切换大小写
            ch[count] = Character.isUpperCase(ch[count])
                    ? Character.toLowerCase(ch[count])
                    : Character.toUpperCase(ch[count]);

            backTrace(ch,count + 1);

            // 回溯，切换大小写
            ch[count] = Character.isUpperCase(ch[count])
                    ? Character.toLowerCase(ch[count])
                    : Character.toUpperCase(ch[count]);
        }


    }
}
