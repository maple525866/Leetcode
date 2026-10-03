package com.code.realtest.backTrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author maple
 * @Description
 * @createTime:2026-10-03 22:52
 */
public class LettersPermutations {
    List<List<Character>> result = new ArrayList<>();
    List<Character> list = new ArrayList<>();
    public static void main(String[] args) {
        LettersPermutations lettersPermutations = new LettersPermutations();
        List<List<Character>> s = lettersPermutations.lettersPermutations("abac");
        System.out.println(s);
    }

    public List<List<Character>> lettersPermutations(String s) {
        char[] ch = s.toCharArray();
        for(char c : ch) {
            list.add(c);
        }
        backTrace(list,0,s.length());
        return result;
    }

    private void backTrace(List<Character> list, int count, int n) {
        if(count == n) {
            result.add(new ArrayList<>(list));
        }

        for(int i = count; i < n; i++) {
            Collections.swap(list, i, count);
            backTrace(list, count + 1, n);
            Collections.swap(list, i, count);
        }
    }
}
