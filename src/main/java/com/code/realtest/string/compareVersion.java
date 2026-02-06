package com.code.realtest.string;

/**
 * @author maple
 * @Description 165. 比较版本号
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 *
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 *
 * 返回规则如下：
 *
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 *
 * 示例 1：
 *
 * 输入：version1 = "1.2", version2 = "1.10"
 *
 * 输出：-1
 *
 * 解释：
 *
 * version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
 *
 * 示例 2：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 *
 * 输出：0
 *
 * 解释：
 *
 * 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
 * @createTime:2026-01-26 19:19
 */
public class compareVersion {
    public static void main(String[] args) {
        String v1 = "1.01";
        String v2 = "1.001";

        System.out.println(compareVersion(v1, v2));
    }

    private static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for(int i = 0; i < v1.length || i < v2.length; i++) {
            int num1 = 0,num2 = 0;

            if(i < v1.length){
                num1 = Integer.parseInt(v1[i]);
            }

            if(i < v2.length){
                num2 = Integer.parseInt(v2[i]);
            }

            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}
