package com.code.hot100.skill;

/**
 * @author maple
 * @Description 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * @createTime:2025-12-11 16:42
 */
public class MajorityElement {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        // 一个事实: 如果一个数组有大于一半的数相同，那么任意删去两个不同的数字，新数组还是会有相同的性质
        int res = nums[0];

        //当前目标数出现次数
        int times = 1;

        for(int i = 1; i < nums.length; i++){
            if(res == nums[i]){
                times++;
            }else{
                if(times == 0){
                    res = nums[i];
                    times = 1;
                }else{
                    times--;
                }
            }
        }

        // 数量大于数组的一半的元素,最后的times不会为0,所以res就只会是它
        return res;
    }
}
