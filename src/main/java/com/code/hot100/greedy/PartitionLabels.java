package com.code.hot100.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple
 * @Description 763. 划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * 示例 2：
 *
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 * @createTime:2025-12-08 17:19
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> integers = partitionLabels.partitionLabels(s);
        System.out.println(integers);
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] edge = new int[26];

        //上一个区间的结束位置
        int last = -1;
        //当前区间的最远右边界
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            // 更新当前区间的最远边界
            edge[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++){
            // 不断更新当前区间的最远边界
            index = Math.max(index, edge[s.charAt(i) - 'a']);

            // 终于达到当前区间最右边界,可以开始收集区间长度
            if(index == i){
                res.add(index - last);
                last = index;
            }
        }
        return res;
    }
}
