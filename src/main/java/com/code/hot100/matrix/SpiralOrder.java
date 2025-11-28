package com.code.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple
 * @Description 54.螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @createTime:2025-11-28 20:27
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = new SpiralOrder().spiralOrder(matrix);

        // List,Map,Set都可以直接sout打印
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0,right = matrix[0].length - 1;
        int top = 0,bottom = matrix.length - 1;

        List<Integer> res = new ArrayList<>();

        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(left > right || top > bottom) break;

            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left > right || top > bottom) break;

            for(int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(left > right || top > bottom) break;

            for(int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(left > right || top > bottom) break;
        }
        return res;
    }
}
