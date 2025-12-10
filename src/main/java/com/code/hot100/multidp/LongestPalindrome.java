package com.code.hot100.multidp;

/**
 * @author maple
 * @Description 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * @createTime:2025-12-10 23:50
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "cbbd";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;

        int start = 0;
        int maxLen = 1;
        int n = s.length();

        // 1.dp[i][j] 代表从下标i 到j的长度子串是否为回文字符串
        boolean[][] dp = new boolean[n][n];

        // 2.初始化,每个字符自己都是回文串
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        // 3.这里用了中心扩展法,所有子串判断是否回文串都是从中心向外判断的,中心+外层一圈是否相同为判断标准
        // 所以为啥这里是先用长度在外层就是这个原因,后面长度逐渐变长,就得靠之前从中心判断作为子问题协助判断是否为回文子串了
        for(int len = 1; len < n; len++){
            for(int i = 0; i < n-len; i++){
                int j = i + len;

                if(s.charAt(i) == s.charAt(j)){
                    // 4.子串长度小于3,外层一圈相同则为回文子串
                    if(j - i <= 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 5.如果当前子串为回文,且长度大于目前记录最大回文子串长度,需要更新
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
