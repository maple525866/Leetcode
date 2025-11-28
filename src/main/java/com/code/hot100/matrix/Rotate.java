package com.code.hot100.matrix;

import java.util.Arrays;

/**
 * @author maple
 * @Description
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * @createTime:2025-11-28 20:41
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(matrix));
        new Rotate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int left = 0,right = matrix[0].length-1;
        int top = 0,bottom = matrix.length-1;

        while(left < right){
            int i = 0;
            while(left + i < right){
                int temp = matrix[top + i][right];
                matrix[top + i][right] = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = temp;
                i++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}
