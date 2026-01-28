package com.code.hot100.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author maple
 * @Description 快速排序
 * @createTime:2025-07-23 14:42
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8,99,1,3,2,6,10,2,4};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr,int left,int right) {
        if(left < right){
            int index = partition(arr,left,right);
            quicksort(arr,left,index - 1);
            quicksort(arr,index + 1,right);
        }
    }

    private static int partition(int[] arr,int left,int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            while(i < j && arr[j] >= pivot){
                j--;
            }
            if(i < j){
                arr[i] = arr[j];
                i++;
            }

            while(i < j && arr[i] < pivot){
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
                j--;
            }
        }

        arr[i] = pivot;

        return i;
    }
}
