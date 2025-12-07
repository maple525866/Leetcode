package com.code.realTest;

/**
 * @author maple
 * @Description 415. 字符串相加（大数相加）
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * @createTime:2025-12-07 14:53
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int store = 0;
        StringBuilder sb = new StringBuilder();
        while(len1 >= 0 || len2 >= 0 || store > 0){
            int i = len1 < 0 ? 0 : num1.charAt(len1--) - '0';
            int j = len2 < 0 ? 0 : num2.charAt(len2--) - '0';

            int res = i + j + store;
            store = res / 10;
            res = res % 10;

            sb.append(res);
        }
        return sb.reverse().toString();
    }
}
