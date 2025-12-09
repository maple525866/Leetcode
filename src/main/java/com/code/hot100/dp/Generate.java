package com.code.hot100.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maple
 * @Description 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 * @createTime:2025-12-09 14:33
 */
public class Generate {
    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        Integer[][] dp = new Integer[numRows][];

        for(int i = 0; i < numRows; i++){
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 每一行的第一个和最后一个元素总是 1
            dp[i][0] = dp[i][i] = 1;

            for(int j = 1; j < i; j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        // 将动态规划数组转换为结果列表
        List<List<Integer>> result = new ArrayList<>();
        for(Integer[] row : dp){
            result.add(Arrays.asList(row));
        }

        return result;
    }
}
