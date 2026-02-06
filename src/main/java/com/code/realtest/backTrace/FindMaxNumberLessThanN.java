package com.code.realtest.backTrace;

/**
 * @author maple
 * @Description 小于n的最大数(回溯)
 * 给一个数n,一个数组A,返回由A中元素组成的小于n的最大数
 * 如
 * n = 23121 ,A = {2,4,9} 返回22999
 * n = 23121 ,A = {9} 返回9999
 * n = 23333 ,A = {2，3} 返回23332
 * n = 2222 ,A = {2} 返回222
 * n = 2, A = {2} 找不到小于n的最大数，只能返回-1
 * @createTime:2026-01-25 23:47
 */
public class FindMaxNumberLessThanN {

    static int res = 0;

    public static void main(String[] args) {
        FindMaxNumberLessThanN findMaxNumberLessThanN = new FindMaxNumberLessThanN();
        int n = 23121;
        int[] arr = {9};

        findMaxNumberLessThanN.findMaxNumberLessThanN(n, arr);

        System.out.println(res);
    }

    private void findMaxNumberLessThanN(int n,int[] arr) {
        backTrace(n,arr,0);
    }

    private void backTrace(int n,int[] arr,int currentNum) {
        if(currentNum > n){
            return;
        }

        if(currentNum < n && currentNum > res){
            res = currentNum;
        }

        for(int i = 0 ; i < arr.length ; i++){
            currentNum = currentNum * 10 + arr[i];
            backTrace(n,arr,currentNum);
            currentNum = currentNum / 10;
        }
    }
}
