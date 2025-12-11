package com.code.hot100.multidp;

/**
 * @author maple
 * @Description 72. 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * @createTime:2025-12-11 15:38
 */
public class MinDistance {
    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        String word1 = "horse";
        String word2 = "ros";

        int i = minDistance.minDistance(word1, word2);
        System.out.println(i);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 1.dp[i][j] = 将 word1 的前 i 个字符 转换为 word2 的前 j 个字符 所需的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // 2.初始化，word1减去i个元素就和word2 = 0的情形一样了
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // 3.初始化，word1加上i个元素就和word2 = 0的情形一样了
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //三种操作里面选一个最小的，然后 + 1就是本次操作所诞生的距离
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
