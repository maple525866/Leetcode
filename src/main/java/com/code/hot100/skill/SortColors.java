package com.code.hot100.skill;

/**
 * @author maple
 * @Description 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * @createTime:2025-12-11 17:27
 */
public class SortColors {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        // 用三个常量记录三种数字出现的次数即可,后面用相应的数字覆盖数组即可
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count0++;
            }else if(nums[i] == 1){
                count1++;
            }else if(nums[i] == 2){
                count2++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(count0 != 0){
                nums[i] = 0;
                count0--;
            }else if(count0 == 0 && count1 != 0){
                nums[i] = 1;
                count1--;
            }else if(count1 == 0 && count2 != 0){
                nums[i] = 2;
                count2--;
            }
        }
    }
}
